# MD5 from Scratch in Java

This project is a complete implementation of the [MD5](https://www.rfc-editor.org/rfc/rfc1321) cryptographic hashing algorithm written entirely from scratch in Java.  
It recreates every step of the algorithm — including bitwise operations, message padding, endian conversions, and 512-bit block processing — without using built-in hashing libraries.

The implementation is verified against standard RFC test vectors and benchmarked against Java’s built-in `MessageDigest` for performance comparison.

---

## Features
- Implements MD5 core algorithm per RFC 1321
- Handles bitwise operations, padding, and endian conversions manually
- Modular design: each MD5 operation is implemented in its own class (`Op_One.java`, `Op_Two.java`, etc.)
- Debug mode for step-by-step output during hashing
- Benchmarking scripts to compare performance with `java.security.MessageDigest`
- Test scripts for correctness verification

---

## Limitations
- Supports input strings up to **55 characters** (single-block MD5)  
- Multi-block support can be added by extending the padding and processing logic for multiple 512-bit blocks

---

## File Overview
- `Main.java` – Main entry point for hashing  
- `Main_Debug.java` – Debug mode main entry point  
- `MD5_actual.java` – Core MD5 logic  
- `Op_One.java` … `Op_Four.java` – MD5 round functions  
- `Op_Final.java` – Final step of MD5 computation  
- `Padding.java` – Message padding implementation  
- `Utils.java` – Utility methods (bitwise ops, endian conversions, etc.)  
- `MD5Test.java` – Additional custom testing harness 
- `makefile` – Compile and run targets  
- `test_actual.sh` – Compare output against system `md5` tool  
- `test_program.sh` – Compare output against Java `MessageDigest`  
- `runtimes.txt` – Recorded benchmark results  

---

## Quick Start

### 1. Compile
```bash
make compile
```

### 2. Run
```bash
make run ARGS="your message here"
```

### 3. Debug Mode
```bash
make run-debug ARGS="your message here"
```

---

## Testing

Compare this implementation to system MD5:
```bash
sh test_actual.sh
```

Compare to Java’s `MessageDigest`:
```bash
sh test_program.sh
```

---

## Benchmarks
`runtimes.txt` contains performance results from this implementation and Java’s built-in `MessageDigest` across multiple input sizes.  
(Example: hash times for short strings, 1 MB, 50 MB.)

---

## Security Note
MD5 is considered cryptographically broken and unsuitable for modern security purposes.  
This implementation is for **educational use only**.

---

## Author
Developed by **Victor Kamrowski** with contributions from **Jason Chao**.

---

## Repository Note
This repository was imported in a single commit from a private development repo where it was originally created and maintained.  
The commit history was reset to remove unrelated school references.

---

## License
MIT License – see `LICENSE` for details.
