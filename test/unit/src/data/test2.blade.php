@extends('layout.layout')

<?php
$searchInput = filter_input(INPUT_GET, 'search_text', FILTER_SANITIZE_STRING);
$loginErrorMessages = json_encode(array(
    'invalid_email' => get_translation('REGISTER_ERROR_INVALID_EMAIL'),
    'password_to_short' => get_translation('STR_PASSWORD_TO_SHORT'),
    ));
?>
@section('body-class','catalog')
@section('CSS')
<link href="@cssFile(catalog_2021.css)" rel="stylesheet" type="text/css"/>
@endsection
@section('JavaScript')
<script src="@jsFile(2021/categoryFilters.js)"></script>
<script>
    window.login = {
    modalId: "loginModal",
            messages: {
            errors:{!! $loginErrorMessages !!}
            }
    };</script>
<script src="@jsFile(login.js)"></script>
@endsection

@section('content')
<?php
if (SiteConfig::get('DESIGN', 'CATALOG_PROMO_INSERTS')){
    $promotionalInserts = [
        0 => [
            'Link' => '/promo',
            'Description' => "Comandée avant 15h, disponible dès 13h le lendemain dans le magasin de votre choix",
            'Title' => "CLICK &<br>COLLECT",
            'PromoMessage' => "Livraison offerte en 24h!",
            'ImgLink' => '',
            'Alt' => 'Promo',
            'Position' => 4
        ],
        1 => [
            'Link' => '/livraison',
            'Description' => "Comandée avant 15h, disponible dès 13h le lendemain dans le magasin de votre choix",
            'Title' => "CLICK &<br>COLLECT",
            'PromoMessage' => "Livraison gratuite en 24h!",
            'ImgLink' => '',
            'Alt' => 'Promo',
            'Position' => 9
        ]
    ];
}
?>
<div class="catalog-wrapper">
    <div class="container">
        <div class="row">
            @if(!empty($filters))
            <div class="filter-list col-lg-3 col-sm-3">
                @include('category.filters')
            </div>
            @endif
            <div class="product-list col-sm-9 col-md-9">
                <ul class="products-catalog" data-type="@yield('products-catalog-data-type', $productsType)">
                    <?php if (empty($productsAfterSearch)):?>
                    @foreach($productsList as $product)
                     <li class="col-sm-6 col-lg-4 productContainer js-product-container type-<?php echo Filters::getStringTypeFromProduct($product); ?> products-list"
                        data-name="{{$product['ProductName']}}"
                        @if (!empty($search_for) && strpos(strtolower($product['ProductName']), strtolower($search_for)) !== false)
                        data-search-for="{{$search_for}}"
                        @endif
                        >
                        @include('category.product', ['product' => $product, 'search_for' => $search_for])
                    </li>
                    @endforeach
                    <?php else:?>
                    @foreach($productsAfterSearch as $product)
                    <li class="col-sm-6 col-lg-4 productContainer js-product-container type-<?php echo Filters::getStringTypeFromProduct($product); ?> product-after-search">
                        @include('category.product', ['product' => $product, 'search_for' => $search_for])
                    </li>
                    @endforeach
                    <?php endif;?>
                    @if (!empty($promotionalInserts))
                    @foreach($promotionalInserts as  $promotionalInsert)
                    <li class="col-sm-6 col-lg-4 productContainer js-product-container products-list type-promo-insert" data-position="{{$promotionalInsert['Position']}}">
                        @include('category.promo_insert', ['promoItem' => $promotionalInsert])
                    </li>
                    @endforeach
                    @endif
                </ul>
            </div>
        </div>
        @if ($categoryDescription)
        <div class="category-description">{{ $categoryDescription }}</div>
        @endif
    </div>
</div>
@endsection
