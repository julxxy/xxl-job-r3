package com.xxl.job.admin.controller;

import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
