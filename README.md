# kpipe

![tests](https://github.com/bkosm/kpipe/actions/workflows/gradle.yml/badge.svg)
![branches](.github/badges/branches.svg)
[![](https://jitpack.io/v/bkosm/kpipe.svg)](https://jitpack.io/#bkosm/kpipe)

Pipe functions that allow for a more functional style of programming.
They support chains of transformation up to 11 in size, providing excellent DX on top.

The library includes:

- `pipe` - a function that pipes the result of one function to the next as a parameter
- `kpipe`- a function that pipes the result of one function to the next as context receiver and the initial value as a
  parameter

> The functions are implemented as a invoke override on the companion, so you can name them whatever you want
> with `typealias`es.

## a little preview

https://github.com/bkosm/kpipe/blob/5af8eff20cc7537f562aef26d4633ac296c5f490/src/test/kotlin/com/bkosm/kpipe/examples/PipeExample.kt#L13-L90

## currently available via JitPack

```kts
repositories {
    // all the other ones that you might need...

    maven { url = uri("https://jitpack.io") }
}

// and then

dependencies {
    // all the other ones that you might need...
    
    testImplementation("com.github.bkosm:kpipe:1.0.0")
}
```

## you decide on the features!

Drop an issue with what functionality you could use in your Kotlin tuple or submit a PR!
