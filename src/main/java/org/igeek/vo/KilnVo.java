package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Gyges on 2017/6/28.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class KilnVo {

    private Integer id;
    private String kilnName;
    private String description;
    private String kilnIdNme;


    public KilnVo() {
    }

    public KilnVo(Integer id, String kilnName, String description) {
        this.id = id;
        this.kilnName = kilnName;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKilnName() {
        return kilnName;
    }

    public void setKilnName(String kilnName) {
        this.kilnName = kilnName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKilnIdNme() {
        return kilnIdNme;
    }

    public void setKilnIdNme(String kilnIdNme) {
        this.kilnIdNme = kilnIdNme;
    }
}
