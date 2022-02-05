<div>
{{-- cc --}}
@if($x)
    <div>
        <div>
            <div class="xx {{$x}}" @if($x) disabled @endif>
                @include("xx")
            </div>

        </div>
    {{-- cc --}}
    @include("xx")
    @includeIf("SDSDSDS")
    {{$xx}}
    </div>
    @endif
</div>