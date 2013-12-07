package ir.university.toosi.tms.view.organ;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.university.toosi.tms.model.entity.BLookup;
import ir.university.toosi.tms.model.entity.WebServiceInfo;
import ir.university.toosi.tms.model.entity.personnel.Organ;
import ir.university.toosi.tms.util.ComponentUtil;
import ir.university.toosi.tms.util.DialogUtil;
import ir.university.toosi.tms.util.RESTfulClientUtil;
import ir.university.toosi.tms.util.ThreadPoolManager;
import ir.university.toosi.tms.view.TMSInternalFrame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author a_hadadi
 */


public class OrganManagementCode extends TMSInternalFrame {

    private OrganManagementPanel panel = null;
    private WebServiceInfo organService = new WebServiceInfo();
    private List<Organ> organList = new ArrayList<>();
    private Organ currentSelectedOrgan = null;
    private TreePath currentPath = null;
    private List<BLookup> bLookups ;
    private List<Object> comboItems;

    public OrganManagementCode(TreePath expandedTreePath) {
        super();
        this.currentPath = expandedTreePath;
        panel = new OrganManagementPanel();
        panel.setLocation(0, 0);
        panel.setSize(panel.getPreferredSize());
        panel.setVisible(true);
        setLayout(null);

        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);


        getContentPane().setBackground(Color.getColor("Control"));

        this.setTitle(ThreadPoolManager.getLangValue("TMS_PERSON_MANAGEMENT")); //


        panel.buttonDelete.setText(ThreadPoolManager.getLangValue("TMS_DELETE"));
        //panel.buttonDelete.setEnabled(ThreadPoolManager.hasPermission("DELET_ORGAN")); //todo

        panel.buttonEdit.setText(ThreadPoolManager.getLangValue("TMS_EDIT"));
        // panel.buttonEdit.setEnabled(ThreadPoolManager.hasPermission("EDIT_ORGAN"));

        panel.buttonAdd.setText(ThreadPoolManager.getLangValue("TMS_ADD"));
        // panel.buttonAdd.setEnabled(ThreadPoolManager.hasPermission("ADD_ORGAN"));
        panel.buttonCancel.setText(ThreadPoolManager.getLangValue("TMS_CANCEL"));

        panel.labelOrganName.setText("نام سازمان");//todo ThreadPoolManager.getLangValue("TMS_OrganNAME")
        panel.labelOrganCode.setText("کد سازمان");
        panel.labelOrganTitle.setText("عنوان سازمان");
        panel.labelOrganType.setText("نوع سازمان");

        this.add(panel);
        refresh();
    }

    private void fillOrganInfoPanel(Organ organ){

        if(null == organ){
            panel.textFieldOrganName.setText("");
            panel.textFieldOrganCode.setText("");
            panel.textFieldOrganTitle.setText("");
            return;
        }

        panel.textFieldOrganName.setText(organ.getName() != null ? organ.getName() : "");
        panel.textFieldOrganCode.setText(organ.getCode() != null ? organ.getCode() : "");
        panel.textFieldOrganTitle.setText(organ.getTitle() != null ? organ.getTitle() : "");
        BLookup bLookup =  organ.getOrganType();
        panel.comboBoxOrganType.setSelectedItem(bLookup);
        for (int i = 0; i < panel.comboBoxOrganType.getModel().getSize(); i++) {
            Object element = panel.comboBoxOrganType.getModel().getElementAt(i);
            if (organ.getOrganType().getId() == ((BLookup)element).getId()) {
                panel.comboBoxOrganType.setSelectedIndex(i);
                break;
            }
        }
    }

    private void refresh() {
        /*currentPath = null;
        currentSelectedOrgan  = null;*/
        try {
            getAll();
            showData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ComponentUtil.SetJTableAlignment(panel.tablePerson, ThreadPoolManager.direction); todo tree
        Font tahoma = new Font("Tahoma", Font.PLAIN, 12);
        ComponentUtil.setFont(panel, tahoma, ThreadPoolManager.direction);

        if (currentPath != null) {
            //expandTree(panel.tree);
            DefaultTreeModel model = (DefaultTreeModel) panel.tree.getModel();

            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    currentPath.getLastPathComponent();
            if (model.isLeaf(node)) {
                if (currentPath.getParentPath() == null
                        || currentPath.getParentPath().getLastPathComponent() == null) {
                    return; //only root exists in tree!!
                }
                currentPath = currentPath.getParentPath();
            }
            expandTree();
        }
    }

    private void getAll() throws IOException {
        organService.setServiceName("/getAllOrgan");//todo or getAllActiveOrgan ?
        organList = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(
                organService.getServerUrl()
                , organService.getServiceName())
                , new TypeReference<List<Organ>>() {
        });

        organService.setServiceName("/getByLookupId");

        try {
            bLookups    = new ObjectMapper().readValue(new RESTfulClientUtil().restFullServiceString(
                    organService.getServerUrl()
                    , organService.getServiceName()
                    , String.valueOf(1l))
                    , new TypeReference<List<BLookup>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        comboItems = new ArrayList<>();
        for (BLookup currentBLookup : bLookups) {
            comboItems.add(currentBLookup);
        }
        panel.comboBoxOrganType.setModel(new javax.swing.DefaultComboBoxModel(comboItems.toArray()));
    }

    private void showData() {
        ArrayList<Organ> organParentList = getMainParents();

        DefaultMutableTreeNode mainParent = new DefaultMutableTreeNode("");//todo
        if(organParentList.size()==1){
            mainParent = new DefaultMutableTreeNode(organParentList.get(0));
            organParentList = getChilds(organParentList.get(0));
        }
        createDefaultMutableTreeNodeFromHierarchy(mainParent, organParentList);
        panel.tree = new JTree(mainParent);
        panel.tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        panel.tree.setComponentOrientation(ThreadPoolManager.direction);
        panel.scrollPane.setViewportView(panel.tree);

        panel.tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        panel.tree.getLastSelectedPathComponent();
                currentSelectedOrgan = null;
                if (node == null) {
                    panel.tree.setSelectionInterval(0, 0);
                    return;
                }
                Object nodeInfo = node.getUserObject();
                currentPath = panel.tree.getSelectionPath();
                currentSelectedOrgan = (Organ) nodeInfo;
                fillOrganInfoPanel(currentSelectedOrgan);
            }
        });

    }

    private ArrayList<Organ> getMainParents() {
        ArrayList<Organ> parents = new ArrayList();

        for (Organ currentOrgan : organList) {
            if (isRootParent(currentOrgan)) {
                parents.add(currentOrgan);
            }
        }

        return parents;
    }

    private void createDefaultMutableTreeNodeFromHierarchy(DefaultMutableTreeNode inputTreeNode, List<Organ> organList) {
        for (Organ currentOrgan : organList) {
            // DefaultMutableTreeNode child = new DefaultMutableTreeNode(currentOrgan.getTitle());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(currentOrgan);
            if (hasChild(currentOrgan)) {
                createDefaultMutableTreeNodeFromHierarchy(child, getChilds(currentOrgan));
            }
            inputTreeNode.add(child);
        }
    }

    private boolean isRootParent(Organ organ) {
        return (organ.getParentOrgan() == null);
    }

    private boolean hasChild(Organ organ) {
        for (Organ currentObject : organList) {
            if (currentObject.getParentOrgan() != null
                    && currentObject.getParentOrgan().getId() == organ.getId()) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Organ> getChilds(Organ organ) {
        ArrayList<Organ> childs = new ArrayList();
        for (Organ currentOrgan : organList) {
            if (currentOrgan.getParentOrgan() != null
                    && currentOrgan.getParentOrgan().getId() == organ.getId()) {
                childs.add(currentOrgan);
            }
        }
        return childs;
    }

    private void emptyJTreeList() {
        organList = null;
        DefaultTreeModel model = (DefaultTreeModel) panel.tree.getModel();
        // DefaultMutableTreeNode model = (DefaultMutableTreeNode)treeService.getModel();
        // model.removeAllChildren();
        Object root = model.getRoot();
        while (!model.isLeaf(root)) {
            model.removeNodeFromParent((MutableTreeNode) model.getChild(root, 0));
        }
    }

    public void expandTree() {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) panel.tree.getModel().getRoot();
        expandTreeRecursive(root);
    }

    public void expandTreeRecursive(DefaultMutableTreeNode node) {

        if (node.getUserObject() != null && !node.getUserObject().toString().trim().isEmpty()) {
            Object tempUserObject = ((DefaultMutableTreeNode) currentPath.getLastPathComponent()).getUserObject();
            Organ organTarget = (Organ) tempUserObject;
            Organ organRecursiveTree = (Organ) node.getUserObject();
            if (organTarget.getId()
                    == organRecursiveTree.getId()) {
                panel.tree.expandPath(new TreePath(node.getPath()));
                return;
            }
        }

        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                DefaultMutableTreeNode n = (DefaultMutableTreeNode) e.nextElement();
                expandTreeRecursive(n);
            }
        }
    }

    private void deleteOrgan() {
        organService.setServiceName("/deleteOrgan");
        try {
            String result = new ObjectMapper().readValue(new RESTfulClientUtil().restFullService(
                    organService.getServerUrl()
                    , organService.getServiceName()
                    , new ObjectMapper().writeValueAsString(currentSelectedOrgan))
                    , String.class);
            if (!result.equalsIgnoreCase("true"))
                //ThreadPoolManager.getLangValue("UNSUCCESSFUL_DELETE")
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        , "در حذف سازمان مورد نظر، خطا رخ داده است."
                        , "خطاي سيستمي"
                );
            else {
                //todo read from bundle
                DialogUtil.showOKDialog(this
                        , "سازمان مورد نظر حذف شد."
                        , "اطلاع رساني"
                );
                refresh();
                fillOrganInfoPanel(null);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class OrganManagementPanel  extends OrganManagementDesign {

        @Override
        protected void buttonCancelActionPerformed() {
            dispose();
        }

        @Override
        protected void buttonEditActionPerformed() {

            if (panel.tree.isSelectionEmpty()) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "سازمان مورد نظر را جهت ويرايش انتخاب نمائيد."
                        , "خطاي ورودي"
                );
                return;
            }

            OrganCode organCode = new OrganCode(currentSelectedOrgan, false, currentPath);
            organCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(organCode);
            try {
                organCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        }

        @Override
        protected void buttonAddActionPerformed() {
             if (panel.tree.isSelectionEmpty()) {
                //todo read from bundle  w
                DialogUtil.showErrorDialog(this
                        , "برای ایجاد سازمان جدید، ابتدا سازمان سرپرست آن را  انتخاب نمائید"
                        , "خطاي ورودي"
                );
                return;
            }

            OrganCode organCode = new OrganCode(currentSelectedOrgan, true, currentPath);
            organCode.setVisible(true);
            ThreadPoolManager.mainForm.getDesktopPane().add(organCode);
            try {
                organCode.setSelected(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dispose();
        }

        @Override
        protected void buttonDeleteActionPerformed() {

            if (panel.tree.isSelectionEmpty()) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "سازمان مورد نظر را جهت حذف انتخاب کنيد"
                        , "خطاي ورودي"
                );
                return;
            }


            if (hasChild(currentSelectedOrgan)) {
                //todo read from bundle
                DialogUtil.showErrorDialog(this
                        , "سازمان مورد نظر نباید زیرمجموعه داشته باشد"
                        , "خطاي ورودي"
                );
                return;
            }


            if (!DialogUtil.showDeleteQuestionDialog(this)) {
                //if (!DialogUtil.showDeleteQuestionDialog(this,ThreadPoolManager.getLangValue("DELETE_PERSON") )) { //todo
                return;
            }

            deleteOrgan();

        }

        @Override
        protected void buttonAllocateActionPerformed() {
            //todo
        }

    }



     /*
        model 1
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
        root.add(child1);
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
        root.add(child2);
        panel.scrollPane.setViewportView(new JTree(root));
        */

    /*  model 2
       JTree tree = new JTree(new DefaultMutableTreeNode("(root)") {
            {
                DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("little");
                node1.add(new DefaultMutableTreeNode("a"));
                node1.add(new DefaultMutableTreeNode("b"));
                node1.add(new DefaultMutableTreeNode("c"));
                add(node1);
                node1 = new DefaultMutableTreeNode("CAPITAL");
                node1.add(new DefaultMutableTreeNode("A"));
                node1.add(new DefaultMutableTreeNode("B"));
                node1.add(new DefaultMutableTreeNode("C"));
                add(node1);
            }
        }) ;
        panel.scrollPane.setViewportView(tree);*/

    /* model 3
    Object[] objects = getMainParents();
    DefaultMutableTreeNode defaultMutableTreeNode= createDefaultMutableTreeNodeFromHierarchy(objects);
    panel.scrollPane.setViewportView(new JTree(defaultMutableTreeNode));*/
}

