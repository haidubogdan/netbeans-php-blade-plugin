<script>
    let config = {
        isActive: @bool($isActive),
        hasAccess: @bool($hasAccess)
    };
</script>

{{-- when --}}
<input name="phone" @when($isRequired, 'required') />