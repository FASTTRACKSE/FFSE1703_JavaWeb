$(window).on("load", function() {
    require.config({
        paths: {
            echarts: "../../../app-assets/vendors/js/charts/echarts"
        }
    }),
    require(["echarts", "echarts/chart/bar", "echarts/chart/line", "echarts/chart/scatter", "echarts/chart/pie"], function(e) {
        var t = e.init(document.getElementById("column-pie"));
        chartOptions = {
            grid: {
                x: 40,
                x2: 40,
                y: 45,
                y2: 25
            },
            tooltip: {
                trigger: "axis"
            },
            legend: {
                data: ["Direct access", "Email marketing", "Advertising alliance", "Video ads", "Browser", "Chrome", "Firefox", "Safari", "Opera"]
            },
            color: ["#00A5A8", "#626E82", "#FF7D4D", "#FF4558", "#16D39A"],
            xAxis: [{
                type: "category",
                splitLine: {
                    show: !1
                },
                data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
            }],
            yAxis: [{
                type: "value",
                position: "right"
            }],
            series: [{
                name: "Direct Access",
                type: "bar",
                data: [320, 332, 301, 334, 390, 330, 320]
            }, {
                name: "Email marketing",
                type: "bar",
                tooltip: {
                    trigger: "item"
                },
                stack: "Advertising",
                data: [120, 132, 101, 134, 90, 230, 210]
            }, {
                name: "Advertising alliance",
                type: "bar",
                tooltip: {
                    trigger: "item"
                },
                stack: "Advertising",
                data: [220, 182, 191, 234, 290, 330, 310]
            }, {
                name: "Video ads",
                type: "bar",
                tooltip: {
                    trigger: "item"
                },
                stack: "Advertising",
                data: [150, 232, 201, 154, 190, 330, 410]
            }, {
                name: "Browser",
                type: "line",
                data: [862, 1018, 964, 1026, 1679, 1600, 1570]
            }, {
                name: "Browser Usage",
                type: "pie",
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                center: [160, 130],
                radius: [0, 50],
                itemStyle: {
                    normal: {
                        labelLine: {
                            length: 20
                        }
                    }
                },
                data: [{
                    value: 1048,
                    name: "Chrome"
                }, {
                    value: 251,
                    name: "Firefox"
                }, {
                    value: 147,
                    name: "Safari"
                }, {
                    value: 102,
                    name: "Opera"
                }]
            }]
        },
        t.setOption(chartOptions),
        $(function() {
            function e() {
                setTimeout(function() {
                    t.resize()
                }, 200)
            }
            $(window).on("resize", e),
            $(".menu-toggle").on("click", e)
        })
    })
});
