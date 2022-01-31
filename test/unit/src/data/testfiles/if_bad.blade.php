@if($product->status == 1)
    <option value = '1' selected='selected'>Actif</option>
    <option value = '0'>Inactif</option>
@else
    <option value = '1'>Actif</option>
    <option value = '0' selected='selected'>Inactif</option>
@endif
        
    
