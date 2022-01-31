@inject('metrics', 'App\Services\MetricsService')    
<div>
    Monthly Revenue: {{ $metrics->monthlyRevenue() }}.
</div>
@section('title', 'Page Title')
('scripts')
This will be first...
@endprepend