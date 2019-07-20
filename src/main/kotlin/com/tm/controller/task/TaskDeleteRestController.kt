package com.tm.controller.task

import com.tm.consts.AppConst
import com.tm.consts.CtrlConst
import com.tm.consts.error.TaskManagerErrorCode
import com.tm.controller.framework.BaseRestController
import com.tm.dto.bean.task.TaskDeleteRequestDto
import com.tm.dto.bean.task.TaskDeleteResponseDto
import com.tm.dto.common.Errors
import com.tm.dto.common.ServiceOut
import com.tm.exception.TaskManagerErrorRuntimeException
import com.tm.service.TaskDeleteService
import com.tm.util.InputInspector
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * タスク削除REST Controller
 */
@RestController
@RequestMapping(CtrlConst.URI_API_VERSION)
class TaskDeleteRestController : BaseRestController() {

    @Autowired
    lateinit var taskDeleteServcie: TaskDeleteService

    /**
     * 実行メソッド
     */
    @RequestMapping(value = [CtrlConst.FUNC_TASKS + CtrlConst.MAP_DELETE], method = [RequestMethod.DELETE])
    @ResponseBody
    @CrossOrigin
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Throws(Exception::class)
    fun delete(@RequestBody req: TaskDeleteRequestDto?): TaskDeleteResponseDto {
        //------------------------------------
        // 入力内容の検査
        //------------------------------------
        var errors: Errors = InputInspector.of<TaskDeleteRequestDto>(req)
                .logInput<TaskDeleteRequestDto>(req)
                .isNull<String>(req?.taskId, TaskManagerErrorCode.ERR210001.code)
                .violateSpecificLength<String>(req?.taskId, AppConst.TASK_ID_LENGTH, TaskManagerErrorCode.ERR210003.code)
                .build()

        //------------------------------------
        // エラーがある場合レスポンス作成処理
        //------------------------------------
        if(errors.codes.isNotEmpty()) throw TaskManagerErrorRuntimeException(errors);

        //------------------------------------
        // サービスクラスの実行およびレスポンス処理
        //------------------------------------
        return BaseRestController.responseProcessBuilder<TaskDeleteResponseDto>()
                .executeService<String>(taskDeleteServcie.delete(req))
                .map<ServiceOut<String>, TaskDeleteResponseDto> { taskId: String, error: Errors -> TaskDeleteResponseDto(taskId, error)}
                .log<TaskDeleteResponseDto>()
                .apply()
    }
}