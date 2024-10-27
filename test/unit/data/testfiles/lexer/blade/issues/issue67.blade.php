{{-- continue highlight --}}
@foreach($tests as $test)  
  @continue(!$items->count() ? true : false)
@endforeach