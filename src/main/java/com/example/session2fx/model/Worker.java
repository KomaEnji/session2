package com.example.session2fx.model;

public class Worker {
    private final int worker_id;
    private final String post;
    private final String name;
    private final String birthday;
    private final String work_phone;
    private final String cabinet;
    private final String corp_email;
    private final int fk_department_id;

    public Worker(int worker_id, String post, String name, String birthday, String work_phone, String cabinet, String corp_email, int fk_departament_id) {
        this.worker_id = worker_id;
        this.post = post;
        this.name = name;
        this.birthday = birthday;
        this.work_phone = work_phone;
        this.cabinet = cabinet;
        this.corp_email = corp_email;
        this.fk_department_id = fk_departament_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public String getPost() {
        return post;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getCorp_email() {
        return corp_email;
    }

    public int getFk_department_id() {
        return fk_department_id;
    }

    @Override
    public String toString() {
        return getPost()+"\n "+getName()+" "+getWork_phone()+" "+getCorp_email()+"\n "+getCabinet();
    }
}
