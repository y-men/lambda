package q.webflux.demo.services;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * NumbersServiceImpl
 */
@Service
public class NumbersServiceImpl implements NumbersService {

    @Override
    public Flux<Long> fetchLongStream(Duration period) {

        return 
         Flux.generate(
            () -> 50, 
            (state, sink) -> {
              sink.next(Long.valueOf(state)); 
              if (state == 200) sink.complete(); 
              return state + 1; 
            })
            .zipWith(Flux.interval(period))
            .map( t->(Long)t.getT1())
            .log(">> "+ this.getClass().getName())
            ;

        }
}