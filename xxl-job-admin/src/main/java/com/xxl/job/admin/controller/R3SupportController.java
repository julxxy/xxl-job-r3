package com.xxl.job.admin.controller;

import com.xxl.job.admin.controller.interceptor.PermissionInterceptor;
import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.model.XxlJobLogGlue;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.dao.XxlJobInfoDao;
import com.xxl.job.admin.dao.XxlJobLogGlueDao;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.glue.GlueTypeEnum;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Those APIs are support for A third-party React-based web admin panel for XXL-JOB.
 *
 * @author weasley
 * @version 1.0.0
 */
@RestController
@RequestMapping("/r3/support/v1")
public class R3SupportController {
    @Autowired
    private XxlJobService xxlJobService;
    @Autowired
    private XxlJobGroupDao xxlJobGroupDao;
    @Autowired
    private XxlJobInfoDao xxlJobInfoDao;
    @Autowired
    private XxlJobLogGlueDao xxlJobLogGlueDao;
    /**
     * 图表数据
     */
    @GetMapping("/job/report/overview")
    public ReturnT<Map<String, Object>> getJobReportOverview() {
        Map<String, Object> info = xxlJobService.dashboardInfo();
        return new ReturnT<>(info);
    }

    /**
     * 用户组权限(执行器)
     */
    @GetMapping("/user/group/permissions")
    public ReturnT<List<XxlJobGroup>> getUserGroupPermissions() {
        List<XxlJobGroup> groupList = xxlJobGroupDao.findAll();
        return new ReturnT<>(groupList);
    }

    /**
     * 获取 Glue 脚本历史版本
     */
    @GetMapping("/job/glue/history")
    public ReturnT<List<XxlJobLogGlue>> index(HttpServletRequest request, @RequestParam("jobId") Integer jobId) {
        XxlJobInfo jobInfo = xxlJobInfoDao.loadById(jobId);

        if (jobInfo == null) {
            throw new RuntimeException(I18nUtil.getString("jobinfo_glue_jobid_unvalid"));
        }
        if (GlueTypeEnum.BEAN == GlueTypeEnum.match(jobInfo.getGlueType())) {
            throw new RuntimeException(I18nUtil.getString("jobinfo_glue_gluetype_unvalid"));
        }

        PermissionInterceptor.validJobGroupPermission(request, jobInfo.getJobGroup());

        List<XxlJobLogGlue> jobLogGlues = xxlJobLogGlueDao.findByJobId(jobId);
        return new ReturnT<>(jobLogGlues);
    }
}
