package com.xxl.job.admin.controller;

import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
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

    @GetMapping("/job/report/overview")
    public ReturnT<Map<String, Object>> getJobReportOverview() {
        Map<String, Object> info = xxlJobService.dashboardInfo();
        return new ReturnT<>(info);
    }
}
