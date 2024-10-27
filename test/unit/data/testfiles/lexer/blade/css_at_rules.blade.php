<style>
    @charset "UTF-8";
    @layer module, state;
    @import "custom.css";
    @layer {
        .alert {
          background-color: brown;
        }
    }
    @supports (transform-origin: 5% 5%) {
    }
    @container (width > 400px) {
        h2 {
          font-size: 1.5em;
        }
      }
    @page {
        size: 8.5in 9in;
        margin-top: 4in;
    }
    
    @-webkit-keyframes swal2-toast-show{
        0% { transform : translateY(-.625em) }
        100%{ transform : translateY(0) }
    }
    
    @keyframes slidein {
        from {
          transform: translateX(0%);
        }

        to {
          transform: translateX(100%);
        }
    }
    
    @notDirective
    @csrf
</style>
