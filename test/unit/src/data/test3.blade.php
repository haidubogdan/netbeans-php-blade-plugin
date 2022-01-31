@php
$availableLocations = Lmc_ProductLocation_Repository::allAvailableLocations();
@endphp
<style>
#productLocationInput{
    height: 22px;
    border-radius: 2px;
    padding: 2px 10px;
}
#filteredLocations {
    border: 1px dotted #ccc;
    padding: 3px;
    background: #fff;
    width: 170px;
    display: none;
    position: absolute;
    right:3px;
}
#filteredLocations ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    max-height:300px;
    overflow:auto;
}
#filteredLocations ul li {
    padding: 5px 0;
}
#filteredLocations ul li:hover {
    background: #eee;
}
.product-location-form label{
    font-weight: bold;
    color:#6b778c;
    padding-right:20px;
}
.input-wrapper{
    position:relative;
}
</style>

    <form method="get" autocomplete="off" class="product-location-form">
        <span class="input-wrapper">
            <label>Product Location Desc</label>
            <input name="ProductLocation" value="" id="productLocationInput" placehoder="location desc"  autofocus=""/>
            <span id="filteredLocations"></span>
        </span>
        <button type="submit">Choisir</button>
    </form>
</div>



