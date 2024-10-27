@can('update')
    <!-- The current user can update the post... -->
@elsecan('create')
    <!-- The current user can create new posts... -->
@else
    <!-- ... -->
@endcan


@canany(['update', 'view', 'delete'])
    <!-- The current user can update, view, or delete the post... -->
@elsecanany(['create'])
    <!-- The current user can create a post... -->
@endcanany

 
@cannot('update')
    <!-- The current user cannot update the post... -->
@elsecannot('create')
    <!-- The current user cannot create new posts... -->
@endcannot


@forelse ($users as $user)
    <li>{{ $user->name }}</li>
@empty
    <p>No users</p>
@endforelse
 

@while (true)
    <p>I'm looping forever.</p>
@endwhile


@switch($i)
    @case(1)
        First case...
        @break
 
    @case(2)
        Second case...
        @break
 
    @default
        Default case...
@endswitch
        
@section('modals')
  <!--contents-->
@append