package q.webflux.demo.services;

import java.time.Duration;

import reactor.core.publisher.Flux;

/**
 * NumbersService
 */
public interface NumbersService {

    public Flux<Long> fetchLongStream(Duration period) ;

}