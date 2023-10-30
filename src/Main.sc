;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use LLRoom)
(use Larry)
(use Patti)
(use Class_255_0)
(use PseudoMouse)
(use Slider)
(use IconI)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use DCIcon)
(use Timer)
(use Grooper)
(use SysWindow)
(use Sound)
(use Cycle)
(use Class_993_0)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	LSL5 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
	gcWin 20
	ll5Win 21
	proc0_22 22
	proc0_23 23
	proc0_24 24
	proc0_25 25
)

(local
	gLarry
	gGame
	global2
	gNewSpeed =  6
	global4
	gCast
	gRegions
	gTimers
	gSounds
	gInv
	gAddToPics
	gNumber
	gGNumber
	gNewRoomNumber
	global14
	global15
	global16
	global17 =  7
	global18
	gCursorNumber
	global20 =  999
	global21 =  20
	global22 =  1
	global23 =  1
	gPEvent
	gTheNewDialog
	global26 =  1
	global27
	gLocales
	global29
	global30 =  10
	gPicAngle
	gFeatures
	gSFeatures
	global34
	global35
	gPicNumber =  -1
	global37
	gWindow
	global39 =  3
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50
	global51
	global52
	global53
	global54
	global55
	global56
	global57
	global58
	global59
	global60
	global61
	global62
	global63
	gLl5FtrInit
	gLl5DoVerbCode
	global66
	global67 =  1
	global68
	gIconBar
	gPEventX
	gPEventY
	gLl5KDHandler
	gLl5MDHandler
	gLl5DirHandler
	global75
	gGLongSongVol
	gPseudoMouse
	gTheDoits
	global79 =  60
	gUser
	global81
	global82
	global83
	gNewEventHandler
	gFont
	global86
	global87
	gCycleCnt
	global89
	global90
	global91
	global92
	global93
	global94
	global95
	global96
	global97
	global98
	global99
	gStopGroop
	global101 =  1234
	gLongSong
	gLongSong2
	global104
	global105
	global106
	global107 =  100
	global108
	gGPEventX
	gGPEventY
	global111
	global112
	global113
	global114
	global115
	global116
	global117
	global118
	global119
	global120
	global121
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	gLowlightColor_4
	global131
	global132
	gLowlightColor_6
	gLowlightColor_5
	global135
	global136
	gLowlightColor_3
	global138
	global139
	global140
	global141
	global142
	global143
	gLowlightColor
	gLowlightColor_2
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	gGCastFirst
	global155
	global156
	global157
	global158
	global159
	global160
	global161
	global162
	global163
	gBlondeX
	gBlondeLoop
	gRedHeadX
	gRedHeadLoop
	global168
	global169
	gLl5Timer
	global171
	global172
	global173
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	gCamcorderTimer
	gGCamcorderTimerSeconds
	gGIconBarCurIcon
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	global195
	global196
	global197
	global198
	global199
)
(procedure (proc0_1 param1)
	(switch param1
		(23
			(= gLarry Larry)
			(= global179 1)
			(User alterEgo: gLarry)
			(gLarry setUpInv:)
		)
		(24
			(= gLarry Patti)
			(= global179 0)
			(User alterEgo: gLarry)
			(gLarry setUpInv:)
		)
	)
)

(procedure (proc0_2)
	(proc0_23)
	(User canControl: 0 canInput: 0)
	(gLarry setMotion: 0)
	(= global169 0)
	(gIconBar eachElementDo: #perform checkIcon)
	(gIconBar disable: 0 1 2 3 4 6 7)
	(if (not (HaveMouse))
		(= gGPEventX gPEventX)
		(= gGPEventY gPEventY)
		(gGame setCursor: global21 1 310 185)
	else
		(gGame setCursor: global21 1)
	)
)

(procedure (proc0_3)
	(User canControl: 1 canInput: 1)
	(gIconBar enable: 0 1 2 3 4 6 7 8)
	(if (not (gIconBar curInvIcon?)) (gIconBar disable: 6))
	(proc0_24)
	(if (not (HaveMouse))
		(gGame
			setCursor: ((gIconBar curIcon?) cursor?) 1 gGPEventX gGPEventY
		)
	else
		(gGame setCursor: ((gIconBar curIcon?) cursor?) 1)
	)
)

(procedure (proc0_4 param1)
	(return (u> (MemoryInfo 1) param1))
)

(procedure (proc0_5 param1 param2)
	(return (if (& (param1 onControl: 1) param2) (return 1) else 0))
)

(procedure (proc0_6 param1)
	(return
		(&
			[global186 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
)

(procedure (proc0_7 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global186 (/ param1 16)]
		(|
			[global186 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
	(return temp0)
)

(procedure (proc0_8 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global186 (/ param1 16)]
		(&
			[global186 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
	(return temp0)
)

(procedure (proc0_9 param1 param2 &tmp temp0)
	(if (== param1 1)
		((Inv at: param2)
			state: param1
			name: {Vymazaná videokazeta}
		)
	else
		(= temp0 (mod ((Inv at: 0) state?) 100))
		((Inv at: temp0)
			state: param1
			name:
				(switch param1
					(2 {Michelle Milken})
					(3 {Lana Luscious})
					(4 {Chi Chi Lambada})
				)
		)
	)
)

(procedure (proc0_10 param1 param2)
	(if (and (> argc 1) (proc0_7 param2)) (= param1 0))
	(if param1
		(gGame changeScore: param1)
		(if (> param1 0) (pointsSound play:))
	)
)

(procedure (proc0_11 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x?))
		(= temp2 (param2 y?))
		(if (== argc 3) (= temp3 param3))
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(= temp0
		(GetAngle (param1 x?) (param1 y?) temp1 temp2)
	)
	(param1
		setHeading: temp0 (if (IsObject temp3) temp3 else 0)
	)
)

(procedure (proc0_12 param1 param2 &tmp [temp0 40] [temp40 10] [temp50 10])
	(StrCpy
		@temp50
		(switch param2
			(1 {Chùze})
			(2 {Dívej se})
			(3 {Dìlej})
			(5 {Mluv})
			(10 {Zip})
			(else  {UNKNOWN VERB})
		)
	)
	(Format @temp40 0 23 gNumber)
	(Format
		@temp0
		0
		24
		(param1 name?)
		@temp50
		((User curEvent?) x?)
		((User curEvent?) y?)
	)
	(Class_993_0
		name: @temp40
		writeString: @temp0 {\0D\n}
		close:
	)
)

(procedure (proc0_13 param1 param2)
	(if (not param1)
		(= global151 0)
		(= global158 0)
		(gIconBar disable: 5)
	else
		(= global151 param1)
		(if (and (> argc 1) (== param1 1000))
			(= global158 param2)
		)
		(gIconBar enable: 5)
	)
)

(procedure (proc0_14 param1 param2 &tmp [temp0 300] temp300 theGPEventX temp302)
	(if gTheNewDialog (gTheNewDialog dispose:))
	(if (not (HaveMouse))
		(= theGPEventX gPEventX)
		(= temp302 (- gPEventY 10))
		(gGame setCursor: gCursorNumber 1 500 500)
	)
	(if (u< param1 1000)
		(GetFarText param1 param2 @temp0)
		(= temp300
			(proc999_3 3 (/ (* global155 (StrLen @temp0)) 120))
		)
		(proc255_0 @temp0 25 temp300 &rest)
	else
		(= temp300
			(proc999_3 3 (/ (* global155 (StrLen param1)) 120))
		)
		(proc255_0 param1 25 temp300 param2 &rest)
	)
	(if (not (HaveMouse))
		(gGame setCursor: gCursorNumber 1 theGPEventX temp302)
	)
	(return 1)
)

(procedure (proc0_15 param1 param2 &tmp temp0)
	(if (< argc 2) (= param2 1))
	(= temp0
		((Event new:)
			type: 16384
			message: param2
			x: (param1 x?)
			y: (param1 y?)
		)
	)
	(param1 handleEvent: temp0)
	(temp0 dispose:)
)

(procedure (proc0_16 &tmp temp0)
	(proc0_3)
	(= temp0 0)
	(while (< temp0 8)
		(if (& global169 (>> $8000 temp0))
			(gIconBar disable: temp0)
		)
		(++ temp0)
	)
)

(procedure (proc0_17 param1 param2 theGLl5Timer param4)
	(if (or (< argc 3) (== theGLl5Timer 0))
		(= theGLl5Timer gLl5Timer)
	)
	(if (> argc 3) (gLl5Timer code: param4))
	(cond 
		((== param2 1) (gLl5Timer setCycle: theGLl5Timer param1))
		((== param2 0) (gLl5Timer set: theGLl5Timer param1))
		(else (gLl5Timer setReal: theGLl5Timer param1))
	)
)

(procedure (proc0_18 param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 200])
	(cond 
		((u< param2 1000) (GetFarText param2 param3 @temp3) (= temp2 2))
		(param2 (StrCpy @temp3 param2) (= temp2 1))
		(else (= temp3 0) (= temp2 0))
	)
	(= temp0 (= temp1 0))
	(if (== param1 gLarry)
		(if (> temp2 1)
			(proc0_14 @temp3 80 {Ty} &rest)
		else
			(proc0_14 @temp3 80 {Ty} param3 &rest)
		)
	else
		(= temp2 temp2)
		(while (< temp2 argc)
			(switch [param2 temp2]
				(108 (= temp0 1))
				(139
					(= temp1 [param2 (++ temp2)])
				)
			)
			(++ temp2)
		)
		(if (param1 underBits?)
			(param1 say: @temp3 0 0 temp0 temp1)
		else
			(param1 init: say: @temp3 0 0 temp0 temp1)
		)
	)
)

(procedure (proc0_22 param1)
	(if param1
		(icon0 loop: 15 cursor: 6)
	else
		(icon0 loop: 0 cursor: 0)
	)
	(if (== (gIconBar curIcon?) icon0)
		(gGame setCursor: (icon0 cursor?))
	)
)

(procedure (proc0_23)
	(if (not gGIconBarCurIcon)
		(= gGIconBarCurIcon (gIconBar curIcon?))
	)
)

(procedure (proc0_24)
	(if gGIconBarCurIcon
		(gIconBar curIcon: gGIconBarCurIcon)
		(gGame setCursor: ((gIconBar curIcon?) cursor?))
		(= gGIconBarCurIcon 0)
		(if
			(and
				(== (gIconBar curIcon?) (gIconBar at: 6))
				(not (gIconBar curInvIcon?))
			)
			(gIconBar advanceCurIcon:)
		)
	)
)

(procedure (proc0_25 param1 param2 theRest &tmp temp0)
	(if gTheNewDialog (gTheNewDialog dispose:))
	(= temp0 (GetPort))
	(SetPort 0)
	(Display
		&rest theRest
		dsALIGN
		dsCOLOR		1
		param2
		dsFONT
		global175
		dsWIDTH
		318
		dsCOORD
		1
		(- 89 (/ (* 14 param1) 2))
	)
	(SetPort temp0)
)

(instance longSong of Sound
	(properties)
)

(instance longSong2 of Sound
	(properties)
)

(instance hotSound of Sound
	(properties)
)

(class WrapMusic of Obj
	(properties
		firstSound 0
		lastSound 0
	)
	
	(method (init)
		(super init:)
		(gLongSong number: firstSound setLoop: 1 play: self)
	)
	
	(method (cue &tmp gLongSongNumber gLongSongVol)
		(if (== (gLongSong prevSignal?) -1)
			(= gLongSongNumber (gLongSong number?))
			(= gLongSongVol (gLongSong vol?))
			(if (> (++ gLongSongNumber) lastSound)
				(= gLongSongNumber firstSound)
			)
			(gLongSong
				number: gLongSongNumber
				play: gLongSongVol self
			)
		)
	)
)

(class ll5Timer of Timer
	(properties
		cycleCnt -1
		seconds -1
		ticksToDo -1
		lastTime -1
		client 0
		code 0
	)
	
	(method (cue)
		(if code (code doit:) (= code 0))
	)
)

(instance camcorderTimer of Timer
	(properties
		seconds 0
	)
	
	(method (doit)
		(if (>= ((Inv at: 0) state?) 100) (super doit:))
	)
	
	(method (cue &tmp temp0)
		(proc0_14 0 0)
		(= temp0 (Inv at: 0))
		(temp0 state: (- (temp0 state?) 100))
	)
)

(class Actions of Code
	(properties)
	
	(method (doVerb)
		(return 0)
	)
)

(instance stopGroop of Grooper
	(properties)
)

(instance quitIcon of DCIcon
	(properties)
	
	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance ll5KDHandler of EventHandler
	(properties)
)

(instance ll5MDHandler of EventHandler
	(properties)
)

(instance ll5DirHandler of EventHandler
	(properties)
)

(instance LSL5 of Game
	(properties)
	
	(method (init &tmp [temp0 6] temp6 temp7)
		(= gStopGroop stopGroop)
		StopWalk
		Timer
		Polygon
		PolyPath
		LLRoom
		IconBar
		Inv
		(ScriptID 982)
		(super init:)
		((ScriptID 16 0) init:)
		(UnLoad 130 16)
		(= gLl5DoVerbCode ll5DoVerbCode)
		(= gLl5FtrInit ll5FtrInit)
		((= gLl5KDHandler ll5KDHandler) add:)
		((= gLl5MDHandler ll5MDHandler) add:)
		((= gLl5DirHandler ll5DirHandler) add:)
		(= gPseudoMouse PseudoMouse)
		((= gLongSong longSong) owner: self flags: 1 init:)
		((= gLongSong2 longSong2) owner: self flags: 1 init:)
		(= gLl5Timer ll5Timer)
		(= gCamcorderTimer camcorderTimer)
		(= global27 {x.yyy.zzz})
		(= global181 {mm/dd/yy})
		(= global182 {991-999-9999})
		(= global112 {992-999-9999})
		(= temp7 (FileIO 0 {verze} 1))
		(FileIO 5 global27 11 temp7)
		(FileIO 5 global181 20 temp7)
		(FileIO 5 global182 20 temp7)
		(FileIO 5 global112 20 temp7)
		(FileIO 1 temp7)
		((= gIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon4 icon5 icon6 icon7 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			curIcon: icon0
			useIconItem: icon6
			helpIconItem: icon9
			disable: 6
			disable:
			state: 3072
		)
		(icon7 message: (if (HaveMouse) 3840 else 9))
		(GameControls
			window: gcWin
			add:
				iconOk
				detailSlider
				(volumeSlider theObj: self selector: 383 yourself:)
				(speedSlider theObj: self selector: 380 yourself:)
				textSlider
				(iconSave theObj: self selector: 78 yourself:)
				(iconRestore theObj: self selector: 79 yourself:)
				(iconRestart theObj: self selector: 104 yourself:)
				(iconQuit theObj: self selector: 103 yourself:)
				(iconAbout
					theObj: (ScriptID 15 0)
					selector: 60
					yourself:
				)
				iconHelp
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor gLowlightColor_5
			helpIconItem: iconHelp
			curIcon: iconSave
			state: 2048
		)
		(= temp6 23)
		(proc0_13 0)
		(if (GameIsRestarting) (MemorySegment 1 @global107))
		(= gLarry Larry)
		(= global179 1)
		(User
			alterEgo: gLarry
			verbMessager: 0
			canControl: 0
			canInput: 0
		)
		(Inv release:)
		(gLarry setUpInv:)
		(self newRoom: global107)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((== ((Inv at: 0) owner?) (Inv at: 1))
				(= global150
					(proc999_2 2000 (= global150 (+ global150 3)))
				)
			)
			((>= ((Inv at: 0) state?) 100) (= global150 (proc999_3 0 (-- global150))))
		)
	)
	
	(method (newRoom)
		(if gTheNewDialog (gTheNewDialog dispose:))
		(= gGCamcorderTimerSeconds 0)
		(if (gCamcorderTimer client?)
			(= gGCamcorderTimerSeconds (gCamcorderTimer seconds?))
			(gCamcorderTimer client: 0)
		)
		(if
			(and
				(IsObject gNewEventHandler)
				(gNewEventHandler elements?)
			)
			(gNewEventHandler eachElementDo: #dispose 1)
		)
		(gIconBar disable:)
		(if (> global151 1000)
			(switch global151
				(1155 (proc0_7 7))
				(1480 (proc0_7 47))
			)
			(= global151 (- global151 1000))
			(super newRoom: &rest)
		else
			(super newRoom: &rest)
		)
	)
	
	(method (startRoom param1)
		((ScriptID 11) doit: param1)
		(if (proc999_5 global151 param1 1000) (proc0_13 0))
		(cond 
			((== param1 200) (Inv release:) (gLarry setUpInv:))
			(
				(proc999_5
					param1
					160
					170
					180
					190
					100
					110
					120
					130
					140
					150
					155
					250
					258
					260
					270
					280
					290
					295
					310
					320
					385
					390
					205
					500
					510
					520
					525
					530
					535
					700
					710
					720
					730
					740
					750
					760
					780
					790
					900
					905
					910
					915
					920
				)
				(if (not global179)
					(DisposeScript 24)
					(Inv release:)
					(gIconBar curInvIcon: 0)
					(gIconBar curIcon: (gIconBar at: 0))
					(proc0_1 23)
				)
			)
			(global179
				(DisposeScript 23)
				(Inv release:)
				(gIconBar curInvIcon: 0)
				(gIconBar curIcon: (gIconBar at: 0))
				(proc0_1 24)
			)
		)
		(if (proc999_5 param1 160 170 180 190) (ScriptID 40))
		(if
		(and global111 (not (proc999_5 param1 200 460)))
			((ScriptID 10 0) init:)
			(= global111 0)
		)
		(gIconBar enable:)
		(super startRoom: param1)
		(if gGCamcorderTimerSeconds
			(gCamcorderTimer
				setReal: gCamcorderTimer gGCamcorderTimerSeconds
			)
		)
		(if
			(and
				(gLarry cycler?)
				(not (gLarry looper?))
				((gLarry cycler?) isKindOf: StopWalk)
			)
			(gLarry setLoop: stopGroop)
		)
	)
	
	(method (restart)
		(global2 style: 6 drawPic: 1)
		(gCast eachElementDo: #hide)
		(MemorySegment 0 @global107 2)
		(super restart:)
	)
	
	(method (handleEvent pEvent)
		(if (== (pEvent type?) evMOUSERELEASE)
			(gLl5MDHandler handleEvent: pEvent)
		else
			(super handleEvent: pEvent)
		)
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
				(evKEYBOARD
					(if
						(and
							(not (proc999_5 gNumber 200 460 700 760 660 390 535 320))
							(DoSound sndSET_SOUND)
						)
						(switch (pEvent message?)
							(KEY_F1
								(hotSound number: 482 play:)
							)
							(KEY_F3
								(hotSound number: 483 play:)
							)
							(KEY_F4
								(hotSound number: 484 play:)
							)
							(KEY_F6
								(hotSound number: 851 play:)
							)
							(KEY_F8
								(hotSound number: 526 play:)
							)
							(KEY_F9
								(hotSound number: 161 play:)
							)
							(KEY_F10
								(hotSound number: 892 play:)
							)
						)
					)
					(switch (pEvent message?)
						(KEY_TAB
							(if (not (& (icon7 signal?) $0004)) (gLarry showInv:))
						)
						(KEY_SHIFTTAB
							(if (not (& (icon7 signal?) $0004)) (gLarry showInv:))
						)
						(KEY_CONTROL
							(gGame quitGame:)
							(pEvent claimed: 1)
						)
						(JOY_RIGHT
							(gIconBar hide:)
							(GameControls show:)
						)
						(KEY_F2
							(cond 
								((gGame masterVolume:) (gGame masterVolume: 0))
								((> global106 1) (gGame masterVolume: 15))
								(else (gGame masterVolume: 1))
							)
							(pEvent claimed: 1)
						)
						(KEY_F5
							(if (not (& ((gIconBar at: 8) signal?) $0004))
								(gGame save:)
								(pEvent claimed: 1)
							)
						)
						(KEY_F7
							(if (not (& ((gIconBar at: 8) signal?) $0004))
								(gGame restore:)
								(pEvent claimed: 1)
							)
						)
						(KEY_EXECUTE
							(if (User controls?)
								(gGame
									setSpeed: (proc999_3 0 (- (gGame egoMoveSpeed?) 1))
								)
							)
						)
						(KEY_SUBTRACT
							(if (User controls?)
								(gGame setSpeed: (+ (gGame egoMoveSpeed?) 1))
							)
						)
						(61
							(if (User controls?) (gGame setSpeed: 6))
						)
					)
				)
			)
		)
	)
	
	(method (setSpeed newSpeed)
		(if argc
			(gLarry cycleSpeed: newSpeed moveSpeed: newSpeed)
			(self egoMoveSpeed: newSpeed)
		)
		(gLarry moveSpeed?)
	)
	
	(method (quitGame &tmp [temp0 10] [temp10 8] newClass_993_0)
		(quitIcon view: 992 loop: 1 cycleSpeed: 9)
		(if
			(proc255_0
				0
				21
				80
				{Takže koneènì odcházíte?}
				81
				{Dobøe, vy dva. Bavte se!}
				1
				81
				{Hej! Zpátky do práce!}
				0
				82
				quitIcon
				0
				0
			)
			(if
				((= newClass_993_0 (Class_993_0 new:))
					name: {MEMORY.DRV}
					open: 1
				)
				(newClass_993_0 readString: @temp0 20 close:)
			)
			(if (newClass_993_0 open: 2)
				(Format @temp10 0 22 global163)
				(newClass_993_0
					writeString: @temp0
					writeString: {\n}
					writeString: @temp10
					close:
				)
			)
			(newClass_993_0 dispose:)
			(super quitGame: 1)
		)
	)
	
	(method (pragmaFail &tmp temp0 temp1 [temp2 30])
		(if (and gTheNewDialog (not global180))
			(gTheNewDialog dispose:)
			(return 1)
		)
		(return
			(if (User canInput:)
				(switch (= temp0 ((User curEvent?) message?))
					(2 (proc0_14 0 1))
					(5 (proc0_14 0 2))
					(3 (proc0_14 0 3))
					(10
						(cond 
							((global2 script?) (proc0_14 0 4))
							(
							(and (!= (gLarry view?) 550) (!= (gLarry view?) 570)) (proc0_14 0 4))
							(global179 (proc0_14 0 5))
							(else (proc0_14 0 6))
						)
					)
					(4
						(= temp1 (Inv indexOf: (gIconBar curInvIcon?)))
						(if global179
							(switch temp1
								(0
									(proc0_14 0 7)
									(proc0_14 0 8 67 -1 185)
								)
								(6 (proc0_14 0 9))
								(7 (proc0_14 0 10))
								(10 (proc0_14 0 11))
								(12 (proc0_14 0 12))
								(16 (proc0_14 0 13))
								(22 (proc0_14 0 14))
								(else 
									(Format @temp2 0 15 ((Inv at: temp1) description?))
									(proc0_14 @temp2)
								)
							)
						else
							(switch temp1
								(3
									(proc0_14 0 16)
									(proc0_14 0 17 67 -1 185)
								)
								(4 (proc0_14 0 18))
								(5 (proc0_14 0 19))
								(7
									(proc0_14 0 16)
									(proc0_14 0 17 67 -1 185)
								)
								(13 (proc0_14 0 20))
								(else 
									(Format @temp2 0 15 ((Inv at: temp1) description?))
									(proc0_14 @temp2)
								)
							)
						)
					)
				)
			else
				0
			)
		)
	)
)

(instance pointsSound of Sound
	(properties
		flags $0001
		number 10
	)
)

(instance icon0 of IconI
	(properties
		view 990
		loop 0
		cel 0
		cursor 0
		message 1
		signal $0041
		helpStr {Pomocí této ikony mùžete pøesunout svou postavu.}
		maskView 990
		maskLoop 14
		maskCel 1
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
	
	(method (select &tmp newEvent)
		(return
			(if (super select: &rest)
				(gIconBar hide:)
				(if (== cursor 6)
					((= newEvent (Event new:)) type: 1 message: 1)
					(if (not (gLl5MDHandler handleEvent: newEvent))
						(gRegions handleEvent: newEvent)
					)
					(newEvent dispose:)
				)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon1 of IconI
	(properties
		view 990
		loop 1
		cel 0
		cursor 1
		message 2
		signal $0041
		helpStr {Tuto ikonu použijte k prohlížení vìcí.}
		maskView 990
		maskLoop 14
		maskCel 1
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_2)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 990
		loop 2
		cel 0
		cursor 2
		message 3
		signal $0041
		helpStr {Tuto ikonu použijte k provádìní úkonù.}
		maskView 990
		maskLoop 14
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_3)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 990
		loop 3
		cel 0
		cursor 3
		message 5
		signal $0041
		helpStr {Pomocí této ikony mùžete mluvit s ostatními postavami.}
		maskView 990
		maskLoop 14
		maskCel 3
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_4)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 990
		loop 10
		cel 0
		cursor 5
		message 10
		signal $0041
		helpStr {Hele, nevíš, k èemu slouží tvùj zip?}
		maskView 990
		maskLoop 14
		maskCel 1
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_5)
		(super init:)
	)
)

(instance icon5 of IconI
	(properties
		view 990
		loop 11
		cel 0
		cursor 999
		message 0
		signal $0043
		helpStr {Tato ikona vám umožní "pøeskoèit" na další interaktivní èást hry.}
		maskView 990
		maskLoop 14
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_2)
		(super init:)
	)
	
	(method (select)
		(return
			(if (and global151 (super select: &rest))
				(gIconBar hide:)
				(if
				(proc255_0 0 25 80 {Rychle vpøed} 81 {Ano} 1 81 {Uups} 0)
					(if (== global151 1000)
						(if (IsObject global158)
							(global158 cue:)
							(proc0_13 0)
						else
							(proc255_0 0 26)
						)
					else
						(global2 newRoom: global151)
						(= global151 (+ global151 1000))
					)
				)
			else
				(return 0)
			)
		)
	)
)

(instance icon6 of IconI
	(properties
		view 990
		loop 4
		cel 0
		cursor 999
		message 4
		signal $0041
		helpStr {Zaškrtnutím této ikony použijete aktuální pøedmìt v inventáøi.}
		maskView 990
		maskLoop 14
		maskCel 4
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_3)
		(super init:)
	)
	
	(method (select param1 &tmp newEvent temp1 gIconBarCurInvIcon temp3 temp4)
		(return
			(cond 
				((& signal $0004) 0)
				((and argc param1 (& signal notUpd))
					(if (= gIconBarCurInvIcon (gIconBar curInvIcon?))
						(= temp3
							(+
								(/
									(-
										(- nsRight nsLeft)
										(CelWide
											(gIconBarCurInvIcon view?)
											(+ (gIconBarCurInvIcon loop?) 1)
											(gIconBarCurInvIcon cel?)
										)
									)
									2
								)
								nsLeft
							)
						)
						(= temp4
							(+
								(gIconBar y?)
								(/
									(-
										(- nsBottom nsTop)
										(CelHigh
											(gIconBarCurInvIcon view?)
											(+ (gIconBarCurInvIcon loop?) 1)
											(gIconBarCurInvIcon cel?)
										)
									)
									2
								)
								nsTop
							)
						)
					)
					(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
					(if (= gIconBarCurInvIcon (gIconBar curInvIcon?))
						(DrawCel
							(gIconBarCurInvIcon view?)
							(+ 1 (gIconBarCurInvIcon loop?))
							(gIconBarCurInvIcon cel?)
							temp3
							temp4
							-1
						)
					)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= newEvent (Event new:)) type?) 2)
						(newEvent localize:)
						(cond 
							((self onMe: newEvent)
								(if (not temp1)
									(DrawCel view loop (= temp1 1) nsLeft nsTop -1)
									(if (= gIconBarCurInvIcon (gIconBar curInvIcon?))
										(DrawCel
											(gIconBarCurInvIcon view?)
											(+ 1 (gIconBarCurInvIcon loop?))
											(gIconBarCurInvIcon cel?)
											temp3
											temp4
											-1
										)
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(temp1
								(DrawCel view loop (= temp1 0) nsLeft nsTop -1)
								(if (= gIconBarCurInvIcon (gIconBar curInvIcon?))
									(DrawCel
										(gIconBarCurInvIcon view?)
										(+ 1 (gIconBarCurInvIcon loop?))
										(gIconBarCurInvIcon cel?)
										temp3
										temp4
										-1
									)
								)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(newEvent dispose:)
					)
					(newEvent dispose:)
					(if (== temp1 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(if (= gIconBarCurInvIcon (gIconBar curInvIcon?))
							(DrawCel
								(gIconBarCurInvIcon view?)
								(+ 1 (gIconBarCurInvIcon loop?))
								(gIconBarCurInvIcon cel?)
								temp3
								temp4
								-1
							)
						)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					temp1
				)
				(else 1)
			)
		)
	)
)

(instance icon7 of IconI
	(properties
		view 990
		loop 5
		cel 0
		cursor 999
		type $0000
		message 0
		signal $0043
		helpStr {Pomocí této ikony vyvoláte okno s inventáøem.}
		maskView 990
		maskLoop 14
		maskCel 2
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_6)
		(super init:)
	)
	
	(method (select)
		(if (super select: &rest)
			(gIconBar hide:)
			(gLarry showInv:)
		)
	)
)

(instance icon8 of IconI
	(properties
		view 990
		loop 7
		cel 0
		cursor 999
		message 8
		signal $0043
		helpStr {Tato ikona vyvolá panel nastavení.}
		maskView 990
		maskLoop 14
		maskCel 1
	)
	
	(method (init)
		(= lowlightColor gLowlightColor)
		(super init:)
	)
	
	(method (select)
		(if (super select: &rest)
			(gIconBar hide:)
			(GameControls show:)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 990
		loop 9
		cel 0
		cursor 9
		message 6
		signal $0003
		helpStr {Chcete-li se seznámit s dalšími ikonami, kliknìte nejprve sem a poté pøejdìte otazníkem na další ikony.}
		maskView 990
		maskLoop 14
	)
	
	(method (init)
		(= lowlightColor gLowlightColor_4)
		(super init:)
	)
)

(instance checkIcon of Code
	(properties)
	
	(method (doit param1)
		(if
			(and
				(param1 isKindOf: IconI)
				(& (param1 signal?) $0004)
			)
			(= global169
				(| global169 (>> $8000 (gIconBar indexOf: param1)))
			)
		)
	)
)

(instance ll5DoVerbCode of Code
	(properties)
	
	(method (doit param1 param2 &tmp temp0 temp1 [temp2 100])
		(= temp0 (param2 description?))
		(switch param1
			(1
				((User curEvent?) claimed: 0)
			)
			(2
				(if (param2 lookStr?)
					(proc0_14 (param2 lookStr?))
				else
					(Format @temp2 0 27 temp0)
					(proc0_14 @temp2)
				)
			)
			(5
				(Format @temp2 0 28 temp0)
				(proc0_14 @temp2)
			)
			(3
				(Format @temp2 0 29 temp0)
				(proc0_14 @temp2)
			)
			(4
				(= temp1 ((gIconBar curInvIcon?) description?))
				(Format @temp2 0 30 temp1 temp0)
				(proc0_14 @temp2)
			)
			(10
				(Format @temp2 0 31 temp0)
				(proc0_14 @temp2)
			)
			(else  (proc0_12 param2 param1))
		)
	)
)

(instance ll5FtrInit of Code
	(properties)
	
	(method (doit param1)
		(if (== (param1 sightAngle?) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions?) 26505) (param1 actions: 0))
		(if
			(and
				(not (param1 approachX?))
				(not (param1 approachY?))
			)
			(param1 approachX: (param1 x?) approachY: (param1 y?))
		)
	)
)

(instance ll5Win of SysWindow
	(properties)
)

(instance gcWin of SysWindow
	(properties)
	
	(method (open &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 [temp8 4] temp12 temp13 [temp14 15] [temp29 4])
		(= temp12 -1)
		(self
			top: (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			left: (/ (- 320 (+ 191 (CelWide 995 0 1))) 2)
			bottom:
				(+
					(CelHigh 995 1 1)
					6
					(/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
				)
			right:
				(+
					191
					(CelWide 995 0 1)
					(/ (- 320 (+ 191 (CelWide 995 0 1))) 2)
				)
			priority: temp12
		)
		(super open:)
		(DrawCel
			995
			0
			6
			(+
				(/
					(-
						(- (+ 191 (CelWide 995 0 1)) (+ 4 (CelWide 995 1 1)))
						(CelWide 995 0 6)
					)
					2
				)
				4
				(CelWide 995 1 1)
			)
			6
			temp12
		)
		(DrawCel 995 1 1 4 3 temp12)
		(DrawCel 995 1 0 94 38 temp12)
		(DrawCel 995 1 0 135 38 temp12)
		(DrawCel 995 1 0 175 38 temp12)
		(DrawCel
			995
			0
			4
			63
			(- 37 (+ (CelHigh 995 0 4) 3))
			temp12
		)
		(DrawCel
			995
			0
			3
			101
			(- 37 (+ (CelHigh 995 0 4) 3))
			temp12
		)
		(DrawCel
			995
			0
			2
			146
			(- 37 (+ (CelHigh 995 0 4) 3))
			temp12
		)
		(DrawCel
			995
			0
			5
			186
			(- 37 (+ (CelHigh 995 0 4) 3))
			temp12
		)
		(= temp5 (+ (= temp2 (+ 46 (CelHigh 995 0 1))) 13))
		(= temp4
			(+
				(= temp3 (+ 10 (CelWide 995 1 1)))
				(-
					(+ 191 (CelWide 995 0 1))
					(+ 10 (CelWide 995 1 1) 6)
				)
			)
		)
		(= temp6 0)
		(= temp7 1)
		(Graph
			grFILL_BOX
			temp2
			temp3
			(+ temp5 1)
			(+ temp4 1)
			temp7
			temp6
			temp12
		)
		(Graph
			grUPDATE_BOX
			temp2
			temp3
			(+ temp5 1)
			(+ temp4 1)
			1
		)
		(Format @temp14 0 32 global15 global16)
		(TextSize @temp29 @temp14 999 0)
		(Display
			@temp14
			dsFONT
			999
			dsCOLOR
			global127
			dsCOORD
			(+
				10
				(CelWide 995 1 1)
				(/
					(-
						(-
							(+ 191 (CelWide 995 0 1))
							(+ 10 (CelWide 995 1 1) 6)
						)
						[temp29 3]
					)
					2
				)
			)
			(+ 46 (CelHigh 995 0 1) 3)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal $0080
		helpStr {Zvýšení množství animace na pozadí. Pokud se vám hra zdá pomalá, snižte ji.}
		sliderView 995
		bottomValue 1
		topValue 5
	)
	
	(method (doit param1)
		(if argc (gGame detailLevel: param1))
		(gGame detailLevel:)
	)
)

(instance volumeSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal $0080
		helpStr {Tímto nastavíte hlasitost.}
		sliderView 995
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal $0080
		helpStr {Tímto se upravuje rychlost Larryho a Patti v rámci možností vašeho poèítaèe.}
		sliderView 995
		bottomValue 15
	)
	
	(method (show)
		(if (not (User controls?))
			(= signal 132)
			(= sliderLoop 9)
		else
			(= sliderLoop 0)
			(= signal 128)
		)
		(super show: &rest)
	)
	
	(method (mask)
	)
	
	(method (move)
		(if (User controls?) (super move: &rest))
	)
)

(instance textSlider of Slider
	(properties
		view 995
		loop 0
		cel 1
		nsLeft 187
		nsTop 37
		signal $0080
		helpStr {Snižte tento posuvník, aby text zùstal na obrazovce déle. Zvyšte jej, pokud ètete rychle.}
		sliderView 995
		bottomValue 24
		topValue 1
	)
	
	(method (doit param1)
		(if argc (= global155 param1))
		(return global155)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 995
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		message 9
		signal $01c3
		helpStr {Slouží k uložení aktuálního stavu hry. Když pozdìji vyberete možnost Obnovit, bude vše pøesnì tak, jak je nyní.}
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 995
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		message 9
		signal $01c3
		helpStr {Tímto obnovíte døíve uloženou hru.}
	)
	
	(method (select)
		(if (< gNumber 160)
			(global2 newRoom: 155)
		else
			(super select: &rest)
		)
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 995
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		message 9
		signal $01c3
		helpStr {Tuto volbu použijte k opìtovnému spuštìní hry od úplného zaèátku.}
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 995
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		message 9
		signal $01c3
		helpStr {Tímto mùžete opustit hru.}
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 995
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		message 9
		signal $01c3
		helpStr {Tady se o tvùrcích této hry dozvíte víc, než byste chtìli vìdìt.}
	)
)

(instance iconHelp of IconI
	(properties
		view 995
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 9
		message 6
		signal $0183
		helpStr {Chcete-li se dozvìdìt nìco o dalších položkách v tomto oknì, kliknìte nejprve sem a pak pøejdìte otazníkem na další položky.}
	)
)

(instance iconOk of IconI
	(properties
		view 995
		loop 8
		cel 0
		nsLeft 8
		nsTop 106
		cursor 9
		message 9
		signal $01c3
		helpStr {Tímto tlaèítkem opustíte tuto nabídku a pokraèujete ve høe.}
	)
)
