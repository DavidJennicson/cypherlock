package com.example.cypher.ent;

import jakarta.persistence.*;

@Entity
@Table
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileid")
    private Long fileid;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filetype")
    private String fileextension;

    @Column(name = "filesize")
    private Long filesize;

    @Column(name = "filedir")
    private String filedir;

    @Column(name = "filepassword")
    private String filepassword;

    public FileEntity(Long fileid, String filename, String fileextension, Long filesize, String filedir, String filepassword) {
        this.fileid = fileid;
        this.filename = filename;
        this.fileextension = fileextension;
        this.filesize = filesize;
        this.filedir = filedir;
        this.filepassword = filepassword;
    }

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFiledir() {
        return filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }

    public String getFilepassword() {
        return filepassword;
    }

    public void setFilepassword(String filepassword) {
        this.filepassword = filepassword;
    }
}
