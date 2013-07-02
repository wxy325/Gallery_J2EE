/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-11
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */

$(document).ready(function()
{
    $("#name").blur(checkName);
    $("#password").blur(checkPassword);
    $("#buttonReset").click(resetLoginInfo);
    $("#buttonSubmit").click(checkAndSubmit);
    $("#head_login").addClass("active");
});


function checkAndSubmit()
{
    var form = document.getElementById("login_form");
    var fName = checkName();
    var fPassword = checkPassword();
    if (fName || fPassword)
    {
        alert("请输入完整信息");
    }
    else
    {
        form.submit();
    }
}
function checkName()
{
    var fCheck = false;
    var name = document.getElementById("name");
    if(name.value.length == 0)
    {
        fCheck = true;
    }
    var name_prompt = document.getElementById("name_prompt");
    if(fCheck)
    {
        name_prompt.style.display = "inline";
    }
    else
    {
        name_prompt.style.display = "none";
    }
    return fCheck;
}
function checkPassword()
{
    var fCheck = false;
    var password = document.getElementById("password");
    if (password.value.length == 0)
    {
        fCheck = true;
    }
    var password_prompt = document.getElementById("password_prompt");
    if(fCheck)
    {
        password_prompt.style.display = "inline";
    }
    else
    {
        password_prompt.style.display = "none";
    }
    return fCheck;
}
function resetLoginInfo()
{
    resetInput("name");
    resetInput("password");
}