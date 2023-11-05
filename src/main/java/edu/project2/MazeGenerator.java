package edu.project2;

public class common {
    data initGeneratorData(int width, int height, cell startPoint){ //used
        data d;
        d.width = width;
        d.height = height;
        d.startPoint.x = startPoint.x;
        d.startPoint.y = startPoint.y;
        d.maze = init(width, height);
        d.maze = setMode(d.startPoint, d.maze, GENVISITED);
        d.s = NULL;
        d.stackSize = 0;
        d.unvisitedNum = unvisitedCount(width, height, d.maze);
        d.error = 0;
        return d;
    }

    data initSeekerData(data d, cell startPoint, cell exitPoint){
        d.maze = finalize(d.width, d.height, d.maze);
        d.startPoint = startPoint;
        d.exitPoint  = exitPoint;
        d.s = NULL;
        d.stackSize = 0;
        d.error = 0;
        return d;
    }

    renderData initRenderData(data d, int windowW, int windowH){
        renderData rd;
        rd.width = d.width;
        rd.height = d.height;
        rd.x = -windowW/2;
        rd.y = -windowH/2;
        GLfloat pSizeX = (GLfloat)(windowW) / (rd.width) ;
        GLfloat pSizeY = (GLfloat)(windowH) / (rd.height);
        if(pSizeX > pSizeY) rd.pSize = pSizeY;
        else                rd.pSize = pSizeX;

        int marginX = (windowW - (rd.pSize * rd.width)) / 2;
        int marginY = (windowH - (rd.pSize * rd.height)) / 2;

        rd.x += marginX;
        rd.y += marginY;

        vertex*      vArray = malloc(rd.width*rd.height*4*sizeof(vertex));
        vertexColor* cArray = malloc(rd.width*rd.height*4*sizeof(vertexColor));
        vertexColor  defaultColor = {0,0,0};
        unsigned long long int vert = 0, i, j;
        for(i = 0; i < rd.height; i++){
            for(j = 0; j < rd.width; j++){
                cArray[vert] = defaultColor;
                vArray[vert].x   = rd.x+rd.pSize*j;
                vArray[vert++].y = rd.y+rd.pSize*i;

                cArray[vert] = defaultColor;
                vArray[vert].x   = rd.x+rd.pSize*j;
                vArray[vert++].y = rd.y+rd.pSize+rd.pSize*i;

                cArray[vert] = defaultColor;
                vArray[vert].x   = rd.x+rd.pSize+rd.pSize*j;
                vArray[vert++].y = rd.y+rd.pSize+rd.pSize*i;

                cArray[vert] = defaultColor;
                vArray[vert].x   = rd.x+rd.pSize+rd.pSize*j;
                vArray[vert++].y = rd.y+rd.pSize*i;
            }
        }
        rd.vertices = vArray;
        rd.vertices_count = vert;
        rd.verticesColor = cArray;
        return rd;
    }

    cellString getNeighbours(unsigned int width, unsigned int height, mazeMatrix maze, cell c, int distance){ //used
        unsigned int i;
        unsigned int x = c.x;
        unsigned int y = c.y;
        cell up = {x, y - distance};
        cell rt = {x + distance, y};
        cell dw = {x, y + distance};
        cell lt = {x - distance, y};
        cell d[4]  = {dw, rt, up, lt};
        unsigned int size = 0;

        cellString cells;
        cells.cells = malloc(4 * sizeof(cell));

        for(i = 0; i < 4; i++){ //для каждого направдения d
            if(d[i].x > 0 && d[i].x < width && d[i].y > 0 && d[i].y < height){ //если не выходит за границ
                unsigned int mazeCellCurrent = maze[d[i].y][d[i].x];
                cell     cellCurrent     = d[i];
                if(mazeCellCurrent != WALL && mazeCellCurrent != GENVISITED && mazeCellCurrent != SEEKED && mazeCellCurrent != WAY){ //и не посещена\является стеной
                    cells.cells[size] = cellCurrent; //записать в массив;
                    size++;
                }
            }
        }

        cells.size = size;
        return cells;
    }

    mazeMatrix setMode(cell c, mazeMatrix maze, int mode){ //used
        unsigned int x = c.x;
        unsigned int y = c.y;
        maze[y][x] = mode;
        return maze;
    }

    unsigned int randomRange(unsigned int low, unsigned int high){ //used

        return rand() % (high - low + 1) + low;
    }


    int save_png_libpng(const char *filename, uint8_t *pixels, int w, int h)
    {
        int i;
        png_structp png = png_create_write_struct(PNG_LIBPNG_VER_STRING, NULL, NULL, NULL);
        if (!png)
            return 0;

        png_infop info = png_create_info_struct(png);
        if (!info) {
            png_destroy_write_struct(&png, &info);
            return 0;
        }

        FILE *fp = fopen(filename, "wb");
        if (!fp) {
            png_destroy_write_struct(&png, &info);
            return 0;
        }

        png_init_io(png, fp);
        png_set_compression_level(png, 4);
        png_set_IHDR(png, info, w, h, 8 /* depth */, PNG_COLOR_TYPE_RGBA, PNG_INTERLACE_NONE,
            PNG_COMPRESSION_TYPE_BASE, PNG_FILTER_TYPE_BASE);
        png_colorp palette = (png_colorp)png_malloc(png, PNG_MAX_PALETTE_LENGTH * sizeof(png_color));
        if (!palette) {
            fclose(fp);
            png_destroy_write_struct(&png, &info);
            return 0;
        }
        png_set_PLTE(png, info, palette, PNG_MAX_PALETTE_LENGTH);
        png_write_info(png, info);
        png_set_packing(png);

        png_bytepp rows = (png_bytepp)png_malloc(png, h * sizeof(png_bytep));
        for (i = 0; i < h; ++i)
            rows[i] = (png_bytep)(pixels + (h - i) * w * 4);

        png_write_image(png, rows);
        png_write_end(png, info);
        png_free(png, palette);
        png_destroy_write_struct(&png, &info);

        fclose(fp);
        free(rows);
        return 1;
    }
}
