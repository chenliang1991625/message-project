package com.my.cn.messageproject.utils.idWork;

import org.springframework.stereotype.Component;

/**
 * StardardIdWorker
 *
 * @author mayanjun(5/1/16)
 */
@Component
public class StardardIdWorker implements IdWorker {

    private IdWorkerHandler handler;

    public StardardIdWorker(int ... indexes) {
        handler = new IdWorkerHandler(indexes);
    }

    public int getMaxIndex() {
        return IdWorkerHandler.MAX_WORKER_INDEX;
    }


    @Override
    public long nextId() {
        return this.handler.nextId();
    }
}
