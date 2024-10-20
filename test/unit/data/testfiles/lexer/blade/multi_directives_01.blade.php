@verbatim
<div class="container">
    Hello, {{ name }}.
</div>
@endverbatim

@if (count($records) === 1)
    I have one record!
@elseif (count($records) > 1)
    I have multiple records!
@else
    I don't have any records!
@endif

@foreach ($users as $user)
    @include('default-navigation', ['x' => $var])
@endforeach
    
<input
    type="checkbox"
    name="active"
    value="active"
    @checked(old('active', $user->active))
/>