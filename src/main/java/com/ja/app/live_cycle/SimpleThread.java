package com.ja.app.live_cycle;

class SimpleThread implements Runnable
{
    public void run()
    {
        try
        {
            Thread.sleep(1500);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After join(): " + MainThread.thread.getState());
    }
}
