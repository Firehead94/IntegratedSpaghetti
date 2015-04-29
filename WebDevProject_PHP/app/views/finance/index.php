<form action="finance/login" method="post" style="display: inline-block; text-align: center; transform: translate(0%, 50%); zoom: 2">
    <label>Student Login</label>
    <input type="textbox" size="20" name="username" placeholder="username" required /><br /><br />
    <input type="password" size="20" name="password" placeholder="password" required /><br /><br />
    <input type="submit" value="Login" /><br />
    <?php if(isset($_GET['error'])) echo 'Invalid Student Login Info'; ?>
</form>