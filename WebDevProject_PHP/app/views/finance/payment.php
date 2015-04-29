<script>
    function set() 
    {
        var str = document.getElementById('select').value;
        if (str !== '' && str !=='new') {
            var json = document.getElementById('select').value;
            var arr = JSON.parse(json);
            document.getElementById('ccn').value = arr['CREDITCARD_NUM'];
            document.getElementById('expdate').value = arr['EXP_DATE'];
            document.getElementById('billingaddress').value = arr['BILLING_ADDRESS'];
            document.getElementById('billingname').value = arr['BILLING_NAME'];
            document.getElementById('billingcity').value = arr['BILLING_CITY'];
            document.getElementById('billingstate').value = arr['BILLING_STATE'];
            document.getElementById('billingzip').value = arr['BILLING_ZIP'];            
            
        }else {
            document.getElementById('ccn').value = "";
            document.getElementById('expdate').value = '';
            document.getElementById('billingname').value = '';
            document.getElementById('billingaddress').value = '';
            document.getElementById('billingcity').value = '';
            document.getElementById('billingstate').value = '';
            document.getElementById('billingzip').value = '';
        }
    }
    
    function swap(json)
    {
        var ret = {};
        for(var key in json){
          ret[json[key]] = key;
        }
        return ret;
    }

</script>

<form id="pay" action="payselect" method="post" style="display: inline-block; text-align: left; zoom: 1.5">
    <select name="paymentoptions" form="pay" id="select" onclick="set()">
        <option value="new">Select...</option>
        <?php foreach($_SESSION['financialinfo'] as $key => $val )  {?>
        <option value='<?php echo json_encode($val) ?>' >CCN:<?php echo $val['CREDITCARD_NUM'] ?>
            &nbsp;&nbsp;EXP:<?php echo $val['EXP_DATE'] ?></option>
        <?php } ?>
        <option value="new" >New Payment Option</option>
    </select>
    
    <input type="textbox" name="ccn" id="ccn" size='20' placeholder="Credit Card Number" required />
    <input type="textbox" name="expdate" id="expdate" size='5' placeholder="EXP Date" required />
    <input type="textbox" name="billingname" id="billingname" size='20' placeholder="Billing Name" required />
    <input type="textbox" name="billingaddress" id="billingaddress" size='20' placeholder="Billing Address" required />
    <input type="textbox" name="billingcity" id="billingcity" size='20' placeholder="Billing City" required />
    <input type="textbox" name="billingstate" id="billingstate" size='20' placeholder="Billing State" required />
    <input type="textbox" name="billingzip" id="billingzip" size='20' placeholder="Billing Zip" required /><br />
    <input type="submit" value="Submit" />

    
</form>

<?php if(isset($_GET['error'])) echo 'Record already exists'; ?>