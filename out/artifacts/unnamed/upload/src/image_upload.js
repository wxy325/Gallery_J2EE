/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-1
 * Time: 下午6:31
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function()
{
//    $("#name").blur(checkName);
//    $("#password").blur(checkPassword);
//    $("#buttonReset").click(resetLoginInfo);
    $("#buttonSubmit").click(checkAndSubmit);
//    $("#head_login").addClass("active");
});

function checkAndSubmit()
{
    var form = document.getElementById("upload_form");
//    var fName = checkName();
//    var fPassword = checkPassword();
//    if (fName || fPassword)
//    {
//        alert("请输入完整信息");
//    }
//    else
//    {
        form.submit();
//    }
}