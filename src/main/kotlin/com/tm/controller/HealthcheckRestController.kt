package com.tm.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.tm.config.AppLogger
import com.tm.consts.CtrlConst
import com.tm.consts.log.LogCode
import com.tm.dto.bean.task.TaskDeleteResponseDto
import com.tm.exception.TaskManagerErrorRuntimeException
import org.jetbrains.annotations.Nullable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * ヘルスチェックREST Controller
 */
@RestController
class HealthcheckRestController {

    /**
     * 実行メソッド
     * @return OK
     */
    @RequestMapping(value = [CtrlConst.MAP_HEALTHCHECK], method = [RequestMethod.GET])
    @ResponseBody
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @Throws(Exception::class)
    fun checkHealthy(): String{
        return "OK"
    }

}
