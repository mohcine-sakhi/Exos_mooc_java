interface Worker {
        void doSth();
        }

interface Worker2 extends Worker {
    void doSth();
}

class WorkerImpl implements Worker, Worker2{
    public void doSth() {
        System.out.println("Doing Something!");
    }
}

class B {
    private void makeWork(Worker worker) {
        worker.doSth();
    }

    public B(){
        Worker worker1 = new WorkerImpl();
        Worker2 worker2 = new WorkerImpl();
        makeWork(worker1);
        makeWork(worker2);
    }
}