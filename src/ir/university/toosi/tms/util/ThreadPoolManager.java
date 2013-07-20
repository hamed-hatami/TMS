package ir.university.toosi.tms.util;

import ir.university.toosi.tms.view.MainForm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author : Hamed Hatami ,  Farzad Sedaghatbin, Atefeh Ahmadi, Mostafa Rastgar
 * @version : 0.8
 */

public class ThreadPoolManager {

    public static final ExecutorService executors = Executors.newCachedThreadPool();
    public static MainForm mainForm;
    public static final ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

}
