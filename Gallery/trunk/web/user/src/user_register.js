$(document).ready(
    function()
    {
        $("#username").blur(checkName);
        $("#password").blur(checkPassword);
        $("#testPassword").blur(checkTestPassword);
        $("#email").blur(checkEmail);
        $("#buttonReset").click(reset);
        $("#buttonSubmit").click(checkAndSubmit);
        $("#head_register").addClass("active");

    }
);

function reset()
{
    resetInput("username");
    resetInput("password");
    resetInput("testPassword");
    resetInput("email");
}
function checkAndSubmit()
{
    var form = document.getElementById("register_form");
    form.submit();
}
function checkName()
{

}
function checkPassword()
{

}
function checkTestPassword()
{

}
function checkEmail()
{

}