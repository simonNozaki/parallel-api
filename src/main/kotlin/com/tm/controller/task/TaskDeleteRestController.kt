package com.tm.controller.task

import com.tm.consts.AppConst
import com.tm.consts.CtrlConst
import com.tm.consts.error.TaskManagerErrorCode
import com.tm.controller.framework.BaseRestController
import com.tm.dto.bean.TaskDeleteRequestDto
import com.tm.dto.bean.task.TaskDeleteResponseDto
import com.tm.dto.common.Errors
import com.tm.dto.common.ServiceOut
import com.tm.exception.TaskManagerErrorRuntimeException
import com.tm.service.TaskDeleteService
import com.tm.util.InputInspector
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

/**
 * タスク削除REST Controller
 */
@RestController
@RequestMapping(CtrlConst.URI_API_VERSION)
@Api(value = "task", tags = ["task"])
class TaskDeleteRestController (private val taskDeleteService: TaskDeleteService) : BaseRestController() {

    /**
     * 実行メソッド
     */
    @RequestMapping(value = [CtrlConst.FUNC_TASKS + CtrlConst.MAP_DELETE], method = [RequestMethod.DELETE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value="タスクを削除します。", tags = [ "task" ])
    @Throws(Exception::class)
    fun delete(@RequestBody req: TaskDeleteRequestDto): TaskDeleteResponseDto {

        println(req)

        //------------------------------------
        // 入力内容の検査
        //------------------------------------
        val errors: Errors = InputInspector.of<TaskDeleteRequestDto>(req)
                .logInput<TaskDeleteRequestDto>(req)
                .isNull<String>(req.taskId, TaskManagerErrorCode.ERR210001.code)
                .violateSpecificLength<String>(req.taskId, AppConst.TASK_ID_LENGTH, TaskManagerErrorCode.ERR210003.code)
                .build()

        //------------------------------------
        // エラーがある場合レスポンス作成処理
        //------------------------------------
        if(errors.codes.isNotEmpty()) throw TaskManagerErrorRuntimeException(errors)

        //------------------------------------
        // サービスクラスの実行およびレスポンス処理
        //------------------------------------
        return responseProcessBuilder<TaskDeleteResponseDto>()
                .executeService<String>(taskDeleteService.delete(req))
                .map<ServiceOut<String>, TaskDeleteResponseDto> { taskId: String, error: Errors -> TaskDeleteResponseDto(taskId, error)}
                .log<TaskDeleteResponseDto>()
                .apply()
    }
}