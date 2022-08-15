@if($x)
<div></div>
    @elseif($x)
        @section("")

        @endsection
<div></div>
    @elseif($x - 1)
    @include("xx")
    @else
<div></div>
@endif