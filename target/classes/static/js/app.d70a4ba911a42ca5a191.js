webpackJsonp([1], {
    "048T": function (t, e) {
    }, M67c: function (t, e) {
    }, NHnr: function (t, e, n) {
        "use strict";
        Object.defineProperty(e, "__esModule", {value: !0});
        var a = n("7+uW"), i = {
            render: function () {
                var t = this.$createElement, e = this._self._c || t;
                return e("div", {attrs: {id: "app"}}, [e("router-view")], 1)
            }, staticRenderFns: []
        };
        var o = n("VU/8")({name: "App"}, i, !1, function (t) {
            n("048T")
        }, null, null).exports, r = n("/ocq"), s = {
            name: "HelloWorld", data: function () {
                return {title: "", date: "", content: "", imgurl: "", appName: "", id: ""}
            }, created: function () {
                this.getdetail()
            }, mounted: function () {
            }, methods: {
                formatTime: function (t, e) {
                    var n = ["Y", "M", "D", "h", "m", "s"], a = [], i = new Date(1e3 * t);
                    for (var o in a.push(i.getFullYear()), a.push(this.formatNumber(i.getMonth() + 1)), a.push(this.formatNumber(i.getDate())), a.push(this.formatNumber(i.getHours())), a.push(this.formatNumber(i.getMinutes())), a.push(this.formatNumber(i.getSeconds())), a) e = e.replace(n[o], a[o]);
                    return e
                }, formatNumber: function (t) {
                    return (t = t.toString())[1] ? t : "0" + t
                }, geshi: function () {
                    $("img").css("width", "100%")
                }, GetQueryString: function (t) {
                    if (new RegExp("(^|\\?|&)id=([^&]*)(\\s|&|$)", "i").test(window.location.href)) {
                        var e = unescape(RegExp.$2.replace(/\+/g, " ")).split("#")[0];
                        this.id = e, console.log(e), console.log(this.id)
                    }
                }, getdetail: function () {
                    var t = this;
                    this.GetQueryString(), console.log(t.id), $.ajax({
                        url: "http://47.99.138.92:8081/develop/getOneNews",
                        dataType: "jsonp",
                        data: {id: t.id},
                        type: "POST",
                        beforeSend: function () {
                        },
                        success: function (e) {
                            console.log(e), t.title = e.data.newsTitle, t.appName = e.data.appName;
                            var n = e.data.createDate, a = e.data.newsContent;
                            -1 !== a.indexOf("img") && t.geshi(), t.content = a.replace(/(\r\n|\n|\r)/gm, "<br />"), console.log(t.content), t.imgurl = e.data.imageUrls, t.date = t.formatTime(n, "Y/M/D"), "" == t.imgurl ? $(".pic").hide() : $(".pic").show()
                        },
                        complete: function () {
                        },
                        error: function () {
                        }
                    })
                }
            }
        }, c = {
            render: function () {
                var t = this, e = t.$createElement, n = t._self._c || e;
                return n("div", {staticClass: "detail"}, [n("header", [t._v("\n    " + t._s(t.title) + "\n  ")]), t._v(" "), n("section", [n("div", {
                    staticClass: "date",
                    staticStyle: {padding: "24px 0 40px 0", "border-bottom": "1px solid #e5e5e5"}
                }, [n("span", {staticStyle: {color: "#666666"}}, [t._v(t._s(t.date))]), t._v(" "), n("span", {
                    staticStyle: {
                        color: "#3D93D9",
                        "margin-left": "10px"
                    }
                }, [t._v("来源：" + t._s(t.appName))])]), t._v(" "), n("div", {staticClass: "pic"}, [n("img", {attrs: {src: t.imgurl}})]), t._v(" "), n("p", {
                    staticClass: "content",
                    domProps: {innerHTML: t._s(t.content)}
                }, [t._v("\n      " + t._s(t.content) + "\n    ")])])])
            }, staticRenderFns: []
        };
        var p = n("VU/8")(s, c, !1, function (t) {
            n("M67c")
        }, "data-v-4cb16c50", null).exports;
        a.a.use(r.a);
        var u = new r.a({routes: [{path: "/", name: "Home", component: p}]}), l = (n("sVYa"), n("mtWM")), d = n.n(l);
        a.a.config.productionTip = !1, a.a.prototype.$axios = d.a, new a.a({
            el: "#app",
            router: u,
            components: {App: o},
            template: "<App/>"
        })
    }
}, ["NHnr"]);
//# sourceMappingURL=app.d70a4ba911a42ca5a191.js.map