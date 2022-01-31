@extends('admin.layout.layout_no_libs')

@section('CSS')
{{-- Bootstrap Navbar --}}
<link href="/admin/inc/bootstrap.navbar.min.css" rel="stylesheet" type="text/css" />
{{-- Toutes les librairies necessaires à DataTable et Editor --}}

@include('admin.layout.bundle_libs_dataTable')
{{-- Body & Navbar --}}
<link href="/laravel/assets/css/admin/admin.css" rel="stylesheet" type="text/css"/>
{{-- Bootstrap Toggle Button --}}
<link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css" rel="stylesheet">
<link href="/laravel/assets/css/admin/select2/select2.min.css" rel="stylesheet">

@endsection