package com.utp.sistema.ventas.model.util;


import com.utp.sistema.ventas.model.Articulo;
import com.utp.sistema.ventas.model.Categoria;
import com.utp.sistema.ventas.model.Cliente;
import com.utp.sistema.ventas.model.Rol;
import com.utp.sistema.ventas.model.Usuario;
import com.utp.sistema.ventas.model.dao.DetalleVentaDao;
import com.utp.sistema.ventas.model.dao.VentaDao;
import com.utp.sistema.ventas.model.dao.impl.DetalleVentaDaoImp;
import com.utp.sistema.ventas.model.dao.impl.VentaDaoImp;
import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class Util {

    VentaDao ventaDao = new VentaDaoImp();
    DetalleVentaDao detalleVentaDao = new DetalleVentaDaoImp();
    public static final int ASCENDENTE = 1;
    public static final int DESCENDENTE = 0;

    public String generateNumComprobante() {

        int num = 0;
        num = ventaDao.findLastNumeroComprobante() + 1;

        String numGenerated = "";
        if (num < 10) {
            numGenerated = "000".concat(String.valueOf(num));
        } else if (num < 100) {
            numGenerated = "00".concat(String.valueOf(num));
        } else if (num < 1000) {
            numGenerated = "0".concat(String.valueOf(num));
        }
        return numGenerated;
    }

    public static String getFecha() {
        return LocalDateTime.now().toString().substring(0, 10);
    }

    public String generateIdVenta() {
        return String.valueOf(ventaDao.getLastIdVenta() + 1);
    }

    public String generateIdDetalleVenta() {
        return String.valueOf(detalleVentaDao.getLastIdDetalleVenta() + 1);
    }

    public static double redondearDecimales(Double valor) {
        double roundDbl = Math.round(valor * 100.0) / 100.0;
        return roundDbl;
    }

    public static Cliente[] ordenarClientesPorNombre(Cliente[] arrayCliente, int modo) {
        for (int i = 0; i < arrayCliente.length - 1; i++) {
            for (int j = 0; j < arrayCliente.length - 1 - i; j++) {
                if (modo == ASCENDENTE) {
                    if (arrayCliente[j].getNombres().compareToIgnoreCase(arrayCliente[j + 1].getNombres()) > 0) {
                        Cliente auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                } else {
                    if (arrayCliente[j].getNombres().compareToIgnoreCase(arrayCliente[j + 1].getNombres()) < 0) {
                        Cliente auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                }
            }
        }
        return arrayCliente;
    }

    public static Articulo[] ordenarArticulosPorNombre(Articulo[] arrayCliente, int modo) {
        for (int i = 0; i < arrayCliente.length - 1; i++) {
            for (int j = 0; j < arrayCliente.length - 1 - i; j++) {
                if (modo == ASCENDENTE) {
                    if (arrayCliente[j].getDescripcion().compareToIgnoreCase(arrayCliente[j + 1].getDescripcion()) > 0) {
                        Articulo auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                } else {
                    if (arrayCliente[j].getDescripcion().compareToIgnoreCase(arrayCliente[j + 1].getDescripcion()) < 0) {
                        Articulo auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                }
            }
        }
        return arrayCliente;
    }

    public static Categoria[] ordenarCategoriaPorNombre(Categoria[] arrayCliente, int modo) {
        for (int i = 0; i < arrayCliente.length - 1; i++) {
            for (int j = 0; j < arrayCliente.length - 1 - i; j++) {
                if (modo == ASCENDENTE) {
                    if (arrayCliente[j].getDescripcion().compareToIgnoreCase(arrayCliente[j + 1].getDescripcion()) > 0) {
                        Categoria auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                } else {
                    if (arrayCliente[j].getDescripcion().compareToIgnoreCase(arrayCliente[j + 1].getDescripcion()) < 0) {
                        Categoria auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                }
            }
        }
        return arrayCliente;
    }

    public static Rol[] ordenarRolPorNombre(Rol[] arrayCliente, int modo) {
        for (int i = 0; i < arrayCliente.length - 1; i++) {
            for (int j = 0; j < arrayCliente.length - 1 - i; j++) {
                if (modo == ASCENDENTE) {
                    if (arrayCliente[j].getNombre().compareToIgnoreCase(arrayCliente[j + 1].getNombre()) > 0) {
                        Rol auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                } else {
                    if (arrayCliente[j].getNombre().compareToIgnoreCase(arrayCliente[j + 1].getNombre()) < 0) {
                        Rol auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                }
            }
        }
        return arrayCliente;
    }

    public static Usuario[] ordenarUsuarioPorNombre(Usuario[] arrayCliente, int modo) {
        for (int i = 0; i < arrayCliente.length - 1; i++) {
            for (int j = 0; j < arrayCliente.length - 1 - i; j++) {
                if (modo == ASCENDENTE) {
                    if (arrayCliente[j].getNombres().compareToIgnoreCase(arrayCliente[j + 1].getNombres()) > 0) {
                        Usuario auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                } else {
                    if (arrayCliente[j].getNombres().compareToIgnoreCase(arrayCliente[j + 1].getNombres()) < 0) {
                        Usuario auxiliar = arrayCliente[j];
                        arrayCliente[j] = arrayCliente[j + 1];
                        arrayCliente[j + 1] = auxiliar;
                    }
                }
            }
        }
        return arrayCliente;
    }
}