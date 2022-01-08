package com.pattern.create.singleton;

/**
 * @version : V1.0
 * @date : 2022/1/8 18:29
 * @Author : LLH
 * @Desc : 线程安全的懒加载;
 */
public class SyncSingleton {
        private static volatile SyncSingleton instance = null;
        private SyncSingleton () {
        };
        public static synchronized SyncSingleton getInstance() {
            if (instance == null) {
                synchronized (instance) {
                    if (instance == null) {
                        instance = new SyncSingleton();
                    }
                }
            }
            return instance;
        }
}
