(function ($) { // this closure helps us keep our variables to ourselves.
// This pattern is known as an "iife" - immediately invoked function expression

    // form the URL
    var url = AJS.contextPath() + "/rest/plugin-demo/1.0/";

    // wait for the DOM (i.e., document "skeleton") to load. This likely isn't necessary for the current case,
    // but may be helpful for AJAX that provides secondary content.
    $(document).ready(function () {
        $("#get-result-btn").bind("click", getResult);
    });
})(AJS.$ || jQuery);

function getResult() {
    var url = AJS.contextPath() + "/rest/plugin-demo/1.0/demo";
    AJS.$.ajax({
        url: url,
        dataType: "json"
    }).then(function (resultMsg) {
        AJS.$("#get-result").text(resultMsg["msg"])
    });
}