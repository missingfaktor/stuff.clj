# stuff.clj

This is a result of me exploring modeling of an object system atop Clojure primitives, on a rather undecisive holiday. The motivation is to understand PL concepts better, and to scratch some itch. This project is not intended for any serious use. 

There is not much here at the moment, but I plan to work on this as and when I find time.

I am not going to get anywhere with this endeavor, unless I read the following books:

1. [The Art of the Metaobject Protocol](http://www.amazon.com/The-Metaobject-Protocol-Gregor-Kiczales/dp/0262610744)
2. [The Why of Y](http://www.dreamsongs.com/Files/WhyOfY.pdf)
3. [Haskell's overlooked object system](http://arxiv.org/pdf/cs/0509027.pdf)

## Example code

```clojure
(define-class Person [name age sex self]
              :name name
              :age age
              :sex sex

              :adult?
              (fn []
                (> (get-attr self :age) 18))

              :older-than?
              (fn [other]
                (> (get-attr self :age)
                   (get-attr other :age))))

(def ashok
  (instantiate Person "Ashok" 20 :male))

(def jaya
  (instantiate Person "Jaya" 17 :female))

(invoke ashok :adult?)

(invoke ashok :older-than? jaya)

(map #(get-attr % :sex) [jaya ashok])
```

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
