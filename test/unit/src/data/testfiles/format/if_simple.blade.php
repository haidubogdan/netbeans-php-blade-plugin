@hasSection($xx)
@endif
@includeIf("internal_view.layout.main")
<div>
    @csrf
</div>
@includeWhen($isUserAdmin, 'users.admin_card', ['user' => $user])