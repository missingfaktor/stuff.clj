(ns stuff.core)

(defn ^{:private true} fix [r]
  ((fn [f]
     (f f))
   (fn [f]
     (r (fn [x]
          ((f f) x))))))

(defmacro define-class [class-name params & body]
  (let [ctor-args (vec (butlast params))
        self-ref (last params)]
    `(defn ~class-name ~ctor-args
       (fn [~self-ref]
         ~(apply hash-map body)))))

(defn instantiate [klass & init-args]
  (fix (apply klass init-args)))

(defn invoke [obj method-name & args]
  (apply (obj method-name) args))

(defn get-attr [obj attr-name]
  (obj attr-name))
