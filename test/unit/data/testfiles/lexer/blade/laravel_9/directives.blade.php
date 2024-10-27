@production
    // Production specific content...
@endproduction
    
@env('staging')
    // The application is running in "staging"...
@endenv
    
@env(['staging', 'production'])
    // The application is running in "staging" or "production"...
@endenv
    
<span @class([
    'p-4',
    'font-bold' => $isActive,
    'text-gray-500' => ! $isActive,
    'bg-red' => $hasError,
])></span>
    
<span @style([
    'background-color: red',
    'font-weight: bold' => $isActive,
])></span>
    
<input type="checkbox"
        name="active"
        value="active"
        @checked(old('active', $user->active)) />

<select name="version">
    @foreach ($product->versions as $version)
        <option value="{{ $version }}" @selected(old('version') == $version)>
            {{ $version }}
        </option>
    @endforeach
</select>

<button type="submit" @disabled($errors->isNotEmpty())>Submit</button>

<input type="email"
        name="email"
        value="email@laravel.com"
        @readonly($user->isNotAdmin()) />

<input type="text"
        name="title"
        value="title"
        @required($user->isAdmin()) />