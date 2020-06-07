package com.tm.dto.bean

import io.swagger.annotations.ApiModelProperty

/**
 * タスク削除リクエストDTOクラス。
 */
data class TaskDeleteRequestDto (

        /**
         * タスクID
         */
        @ApiModelProperty(value = "\${TaskDeleteRequestDto.taskId}")
        var taskId: String
)