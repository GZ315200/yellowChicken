package org.igeek.vo;

/**
 * Created by Gyges on 2017/6/28.
 */
public class KilnVo {

    private Integer id;
    private String kilnName;
    private String description;


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
}
