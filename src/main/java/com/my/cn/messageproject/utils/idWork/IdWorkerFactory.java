package com.my.cn.messageproject.utils.idWork;

/**
 * IdWorkerBuilder
 *
 * @author mayanjun(5/1/16)
 */
public class IdWorkerFactory {

    public static IdWorker create(int ... indexes) {
        return new StardardIdWorker(indexes);
    }
}
