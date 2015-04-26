<form id="pay" action="payment" method="post" >
    <script>
    function selected() {
        var url = window.location.href;
        if (document.getElementById('select').value === 'new') {            
            if (url.indexOf('?') > -1){
                url = url.substring(0,url.indexOf('?')) + '?option=' + document.getElementById('select').value
             }else{
                 url += '?option=' + document.getElementById('select').value
             }
           
            window.location.href = url;
        } else {
            window.location.href = url.substring(0,url.indexOf('?'));
        }
    }    
    
    </script>
        

    <select name="paymentoptions" form="pay" onchange="selected()" id="select">
        <option value="">Select...</option>
        <?php foreach($_SESSION['financialinfo'] as $key => $val )  {?>
        <option value="<?php $val['CREDITCARD_NUM'] ?>">CCN:<?php echo $val['CREDITCARD_NUM'] ?>
            &nbsp;&nbsp;EXP:<?php echo $val['EXP_DATE'] ?></option>
        <?php } ?>
        <option value="new">New Payment Method</option>
    </select>
    
    <?php if(isset($_REQUEST['option']) && $_REQUEST['option'] = 'new') { ?>
        place input form here for getting financial info for new card
    <?php }?>
    
</form>