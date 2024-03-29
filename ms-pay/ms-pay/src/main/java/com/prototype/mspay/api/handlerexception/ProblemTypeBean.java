package com.prototype.mspay.api.handlerexception;

import lombok.Getter;

@Getter
public class ProblemTypeBean {

    private String title;
    private String url;

    ProblemTypeBean(ProblemType problemType, String url) {
        this.url = url + problemType.getPath();
        this.title = problemType.getTitle();
    }
}
