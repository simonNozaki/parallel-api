package com.tm.dto.bean.task;

import io.swagger.annotations.ApiModelProperty;

/**
 * タスク削除リクエストDTO。
 */
public class TaskDeleteRequestDto {

    /**
     * タスクID
     */
    @ApiModelProperty(value="${TaskDeleteRequestDto.taskId}")
    private String taskId;

    public String getTaskId() {
        return taskId;
    }
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
